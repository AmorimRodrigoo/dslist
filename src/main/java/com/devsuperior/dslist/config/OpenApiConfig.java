package com.devsuperior.dslist.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("Rest API with Java 21 and Spring Boot 3")
                        .version("v1")
                        .description("List of games organized by category ")
                        .license(
                          new License()
                                  .name("MIT License ")
                                  .url("https://github.com/AmorimRodrigoo/dslist/blob/main/LICENSE")));

    }
}
