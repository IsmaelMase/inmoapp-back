package io.core_rest_client.core_rest_client.swagger;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//Anotar como  configuración de Spring
@Configuration
// Habilitar Swagger
@EnableSwagger2
public class SwaggerConfig {

	@Value("${spring.application.name}")
	private String applicationName;

	@Autowired
	private Environment environment;

	@Autowired
	private SwaggerServiceCofig routeLocator;

	// private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new
	// HashSet<String>(
	// Arrays.asList("application/json", "application/xml"));
	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(
			Arrays.asList("application/json"));

	// Definir el Bean Docket

	@Bean
	public Docket api() {

		// Boolean profileWAR = false;
		//
		// String[] profiles = this.environment.getActiveProfiles();

		// for (String profile : profiles) {
		// if (profile.equalsIgnoreCase("war")) {
		// profileWAR = true;
		// break;
		// }
		// }

		Docket docket = new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
				.produces(DEFAULT_PRODUCES_AND_CONSUMES).consumes(DEFAULT_PRODUCES_AND_CONSUMES).select()
				.paths(PathSelectors.any()).paths(Predicates.not(PathSelectors.regex("/error")))
				.apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot"))).build();

		// docket.securitySchemes(Arrays.asList(apiKey())).securityContexts(Arrays.asList(securityContext()));
		return docket;
	}

	// @Bean
	// public Docket api() {
	// return new
	// Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.any())
	// .paths(Predicates.not(PathSelectors.regex("/error"))).build();
	// }

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("AppIn Backend").description("Swagger").version("0.1").build();
	}

	// private ApiKey apiKey() {
	// return new ApiKey("apiKey", "Authorization", "header");
	// }

	// @Bean
	// public SecurityConfiguration security() {
	// return
	// SecurityConfigurationBuilder.builder().scopeSeparator(",").additionalQueryStringParams(null)
	// .useBasicAuthenticationWithAccessCodeGrant(false).build();
	// }
	//
	// private SecurityContext securityContext() {
	// return
	// SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.any()).build();
	// }
	//
	// private List<SecurityReference> defaultAuth() {
	// AuthorizationScope authorizationScope = new AuthorizationScope("global",
	// "accessEverything");
	// AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
	// authorizationScopes[0] = authorizationScope;
	// return Arrays.asList(new SecurityReference("apiKey", authorizationScopes));
	// }

	/**
	 * @return the applicationName
	 */
	public String getApplicationName() {
		return applicationName;
	}

	/**
	 * @param applicationName
	 *            the applicationName to set
	 */
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	/**
	 * @return the environment
	 */
	public Environment getEnvironment() {
		return environment;
	}

	/**
	 * @param environment
	 *            the environment to set
	 */
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

}
