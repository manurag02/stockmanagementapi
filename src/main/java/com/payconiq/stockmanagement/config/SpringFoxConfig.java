package com.payconiq.stockmanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SpringFoxConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.payconiq.stockmanagement"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Payconiq Stock Management REST API",
                "Manage stocks the REST way.",
                "version 1",
                "Terms of service",
                new Contact("Anurag Mishra", "https://www.linkedin.com/in/anurag-mishra-2b167080/", "anurag.r.mishra@protonmail.com"),
                "License of API", "API license URL", Collections.emptyList());
    }
}
