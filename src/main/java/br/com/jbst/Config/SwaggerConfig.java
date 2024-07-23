package br.com.jbst.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
	

		@Bean
		public OpenAPI customOpenApi() {
			return new OpenAPI().components(new Components()).info(new Info().title("API da Segurança do Trabalho - JBST Sistemas")
					.description("Nesta API temos os Serviços de Busca do Financeiro").version("v1"));
		}
}
