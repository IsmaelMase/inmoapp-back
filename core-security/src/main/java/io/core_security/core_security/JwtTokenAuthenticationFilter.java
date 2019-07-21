package io.core_security.core_security;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.core_security.core_security.config.SecurityPropertiesConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.DefaultClaims;

public class JwtTokenAuthenticationFilter extends OncePerRequestFilter {

	private SecurityPropertiesConfig securityPropertiesConfig;

	public JwtTokenAuthenticationFilter(SecurityPropertiesConfig securityPropertiesConfig) {
		this.securityPropertiesConfig = securityPropertiesConfig;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		// 1. Recoger el header donde viene el token
		String header = request.getHeader(securityPropertiesConfig.getJwt().getHeader());

		// 2. Validar el encabezado y el prefijo (Bearer)
		if (header == null || !header.startsWith(securityPropertiesConfig.getJwt().getPrefix())) {
			chain.doFilter(request, response); // Si no es válido se continua con la cadena de filtros (¿acceso a
												// recurso público?)
			return;
		}

		// Si hay un token de autenticación, se valida que sea correcto

		// 3. Se obtiene el token
		String token = header.replace(securityPropertiesConfig.getJwt().getPrefix(), "");

		try {
			// Las excepciones se lanzarán al crearse los claims (por ejemplo cuando el
			// token ha expirado

			// 4. Validar el token
			Claims claims = null;
			try {
				claims = Jwts.parser().setSigningKey(securityPropertiesConfig.getJwt().getSecret().getBytes())
						.parseClaimsJws(token).getBody();
			} catch (ExpiredJwtException e) {
				// Si el token ha expirado, salta ExpiredJwtException y hay que rearmar las
				// claims manualmente aprovechando el token
				String[] split_string = token.split("\\.");
				String base64EncodedBody = split_string[1];
				String body = new String(Base64.getDecoder().decode(base64EncodedBody));
				@SuppressWarnings("unchecked")
				HashMap<String, Object> mapaClaims = new ObjectMapper().readValue(body, HashMap.class);
				claims = new DefaultClaims(mapaClaims);
			}

			String username = claims.getSubject();
			if (username != null) {
				@SuppressWarnings("unchecked")
				List<String> authorities = (List<String>) claims.get("authorities");

				// 5. Crear un objeto de autenticación
				// UsernamePasswordAuthenticationToken: Lo usa spring para representar al
				// usuario autenticado o que se va a autenticar
				// Necesitará una lista de autoridades, con la interfaz GrantedAuthority, siendo
				// SimpleGrantedAuthority una implementación de esa interfaz
				UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(username, null,
						authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));

				// 6. Autenticar al usuario
				// Para spring security
				SecurityContextHolder.getContext().setAuthentication(auth);
			}

			// Se continua con la cadena de filtros
			chain.doFilter(request, response);

		} catch (Exception e) {
			// Si hay fallo, nos garanrizamos que el usuario no se autentica
			SecurityContextHolder.clearContext();
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		}
	}

	public String convertObjectToJson(Object object) throws JsonProcessingException {
		if (object == null) {
			return null;
		}
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(object);
	}
}
