package com.phonebook.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket apidoc() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.phonebook.rest"))
				.paths(regex("/api.*"))
				.build();
	}
	
	/* @Bean
	public Docket apidoc() {
		return new Docket(DocumentationType.SWAGGER_2) // Swagger Screen
				.select() // read rest controllers
				.apis(basePackage("com.phonebook.rest")) // (api)rest controller from common package name
				.paths(regex("/api.*")) // having one common starting path (/.*)
				.build() //create screen
				.useDefaultResponseMessages(false) // hide error codes at swagger
				;
		
	}*/

}
