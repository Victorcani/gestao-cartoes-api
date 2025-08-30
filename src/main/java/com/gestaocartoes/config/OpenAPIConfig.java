package com.gestaocartoes.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "API Gestão de Cartões",
        version = "1.0",
        description = "Documentação da API para gestão de clientes, cartões e transações"
    ),
    servers = {
        @Server(url = "http://localhost:8081", description = "Servidor Local")
    }
)
public class OpenAPIConfig {
}