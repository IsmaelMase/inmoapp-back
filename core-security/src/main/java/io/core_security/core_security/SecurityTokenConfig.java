package io.core_security.core_security;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import io.core_security.core_security.config.SecurityPropertiesConfig;

@EnableWebSecurity
public class SecurityTokenConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private SecurityPropertiesConfig securityPropertiesConfig;

	private static final String[] AUTH_WHITELIST = {

			// -- swagger ui
			"/swagger-resources/**", "/swagger-ui.html", "/v2/api-docs", "/webjars/**" };

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable()
				// make sure we use stateless session; session won't be used to
				// store user's state.
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				// handle an authorized attempts
				.exceptionHandling()
				.authenticationEntryPoint((req, rsp, e) -> rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED)).and()
				// Añadimos el filtro para validar el token en cada petición
				.addFilterAfter(new JwtTokenAuthenticationFilter(securityPropertiesConfig),
						UsernamePasswordAuthenticationFilter.class)
				// Ahora se configuran las peticiones que se van a autotorizar
				.authorizeRequests()
				// Se permite la conexión a los patrones de la whitelist
				.antMatchers(AUTH_WHITELIST).permitAll()
				// Para el resto de llamadas a componentes, al menos debe estar
				// autenticado, ya se comprobará el rol en cada método concreto
				.anyRequest().authenticated();
	}
}