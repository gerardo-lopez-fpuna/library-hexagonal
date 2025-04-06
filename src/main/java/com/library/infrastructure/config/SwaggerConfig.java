package com.library.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI libraryOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Library API - Hexagonal Architecture")
                        .description("Documentación de la API REST para el sistema de biblioteca")
                        .version("v1.0")
                        .contact(new Contact()
                                .name("Equipo de Desarrollo")
                                .email("dev@library.com")
                                .url("https://library.com")));
    }
}