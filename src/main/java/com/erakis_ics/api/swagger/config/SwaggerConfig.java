package com.erakis_ics.api.swagger.config;

import java.util.LinkedList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

/*  
 * @author by: icarlos 
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.erakis_ics.api"))
				.paths(regex("/api.*"))
				.build()
				.apiInfo(metaInfo());
	}

	private ApiInfo metaInfo() {
		@SuppressWarnings("rawtypes")
		ApiInfo apiInfo = new ApiInfo(
				"ERAKIS ICS REST API", 
				"ERAKIS Tecnologia em Sistemas", 
				"0.2.1", 
				"TERMS OF SERVICE", 
				new Contact(
						"ICS Systems",
						"https://erakis.com.br", 
						"erakisti@gmail.com"), 
						"Apache License Version 2.0", 
						"http://www.apache.org/licenses/LICENSE-2.0",
						new LinkedList<VendorExtension>()
				);
		return apiInfo;
	}
}
