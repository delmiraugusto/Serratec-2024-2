package br.com.serratec.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class ApiConfig{
	
	@Value("${dominio.openapi.dev-url}")
	private String devUrl;
	
	@Value("${dominio.openapi.prod-url}")
	private String prodUrl;
	
	@Bean
	public OpenAPI myOpenApi () {
		Server devServer = new Server();
		devServer.setUrl(devUrl);
		devServer.setDescription("URL da área de desenvolvimento");
		
		Server prodServer = new Server();
		devServer.setUrl(prodUrl);
		devServer.setDescription("URL da área de produção");
		
		Contact contact = new Contact();
		contact.setName("Luis Filipe, "
				+ "Rafael Freire, " + "Larissa Teodoro, " + "Denilson Santos, " + "Delmir Augusto");
		contact.setUrl("https://www.serratec.com.br");
		
		License apacheLicense = new License().name("Apache").url("https://www.apache.org/licenses/LICENSE-2.0");
		
		Info info = new Info().title("API TRABALHO 2").version("1.0").contact(contact)
				.description("API PARA TRABALHO").termsOfService("https://www.serratec.com.br")
				.license(apacheLicense);
		
		return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
	}
}
