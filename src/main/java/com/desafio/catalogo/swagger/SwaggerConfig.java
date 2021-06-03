package com.desafio.catalogo.swagger;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2

public class SwaggerConfig {
	@Bean
	public Docket productApi() {
		return (new Docket(DocumentationType.SWAGGER_2))
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.desafio.catalogo.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(this.metaInfo());
	}

	private ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo("Catalogo de produtos API REST", 
				"API REST de produtos",
				"1.0",
				"Terms of Service",
				new Contact("Bruno Carvalho",
						"https://www.linkedin.com/in/bruno-carvalho-9810/",
						"brunocarvalho9810@gmail.com"),
				"Apache License Version 2.0",
				"https://www.apache.org/licesen.html",
				new ArrayList<>());

		return apiInfo;
	}
}
