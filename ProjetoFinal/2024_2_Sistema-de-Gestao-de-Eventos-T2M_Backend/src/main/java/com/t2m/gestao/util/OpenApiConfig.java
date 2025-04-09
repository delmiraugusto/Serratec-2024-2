package com.t2m.gestao.util;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(info = @Info(
		title = "Api para um Gestor de Eventos!",
		version = "1.0",
		description = "Documentação da API Gestão de Eventos."
		))
public class OpenApiConfig {
	
	
}