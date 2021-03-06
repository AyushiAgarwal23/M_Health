package com.cg.mHealthSystem;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



/**
 * 
 * @author ayushranjan
 *
 *This a common swagger class all the controllers 
 *
 */
@Configuration
@EnableSwagger2
public class MHealthSwagger {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(metadata()).select().paths(regex("/.*")).build();
	}
	@SuppressWarnings("deprecation")
	private ApiInfo metadata() {
		return new ApiInfoBuilder().title("M-Health System").description("API reference guide for developers").termsOfServiceUrl("https://www.ayush.com/").contact("Ranjan, Ayush").version("1.0").build();	
	}


}
