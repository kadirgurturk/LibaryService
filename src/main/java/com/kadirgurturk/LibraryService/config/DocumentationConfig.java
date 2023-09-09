package com.kadirgurturk.LibraryService.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition
@Configuration
public class DocumentationConfig {

    @Bean
    public OpenAPI baseOpenApı(){
        return new OpenAPI().info(new Info()
                .title("Todo Rest Api")
                .version("1.0.0")
                .description("Rest Api for TodoApp"));
    }
}