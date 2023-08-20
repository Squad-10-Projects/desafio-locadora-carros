package com.example.demo.model.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Squad 10",
                        url = "https://github.com/Squad-10-Projects/desafio-locadora-carros"
                ),
                description = "Documentação do desafio da Locadora de Veículos proposto pelo projeto Solutis School",
                title = "Documentação - Squad 10"
        )
)
public class OpenApiConfig {
}
