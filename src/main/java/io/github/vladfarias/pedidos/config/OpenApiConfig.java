package io.github.vladfarias.pedidos.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI pedidosOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Pedidos")
                        .description(
                                "API REST para cadastro, consulta, " +
                                        "atualização e exclusão de pedidos"
                        )
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Vladimir Farias")
                        )
                );
    }
}