package br.com.groupfive.jobby.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "testeName",
                        email = "testeEmail",
                        url = "testeUrl"
                ),
                description = "testeDescricao",
                title = "testeTitle",
                version = "testeVersion",
                license = @License(
                        name = "testeLicenseName",
                        url = "testeLicenseUrl"
                ),
                termsOfService = "Terms of Service"
        ),
        servers = {
                @Server(
                        description = "Local DEV",
                        url = "http://localhost:8080"
                ),
                @Server(
                        description = "Local PROD",
                        url = "urlApi "
                )
        }
)
public class SwaggerConfig extends WebMvcConfigurationSupport {



}
