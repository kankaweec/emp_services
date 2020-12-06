package com.th.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class SpringBootSwaggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSwaggerApplication.class, args);
	}

//	@Bean
//	public Docket swaggerConfigs() {
//
//		return new Docket(DocumentationType.SWAGGER_2)
//				.select()
//				.paths(PathSelectors.ant("/api/**"))
//				.apis(RequestHandlerSelectors.basePackage("com.th.employee"))
//				.build()
//				.apiInfo(createApiInfo());
//	}
	
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
          .select()
          .apis(RequestHandlerSelectors.basePackage("com.th.employee"))
          .paths(PathSelectors.ant("/api/**"))
          .build()
          .apiInfo(createApiInfo())
          .securitySchemes(Arrays.asList(apiKey()));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("REST API")
                .description("The REST API for demo swagger.").termsOfServiceUrl("")
                .contact(new Contact("RICH LEE", "", "rich.lee@gmail.com"))
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .version("0.0.1")
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey("authkey", "Authorization", "header");
      }

	public ApiInfo createApiInfo(){
		return new ApiInfo("Employee information api",
				"Simple REST API for employees service",
				 "1.0",
				"Free to use",
				new Contact("Kankawee Chanthorn", null,"kankawee.cht@gmail.com"),
				"API license",
				null,
				Collections.emptyList());
	}





}
