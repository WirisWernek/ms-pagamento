package tech.wiriswernek.ms_pagamento;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;


@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Pagamentos API",
                version = "1.0.0",
                description = "API de Gerenciamento de Pagamentos",
                termsOfService = "wiriswernek",
                contact = @Contact(
                        name = "Wiris Wernek",
                        email = "wiriswernek@gmail.com"
                ),
                license = @License(
                        name = "licence",
                        url = "license"
                )
        )
)
public class MsPagamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsPagamentoApplication.class, args);
	}

	@Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .servers(List.of(
                    new Server().url("/").description("Default Server URL")
                ));
    }
}
