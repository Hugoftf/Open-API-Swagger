package com.github.Hugoftf.Spring.JPA.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Estudando Spring Framework",
                version = "v1",
                contact = @Contact(
                        name = "Hugo de França",
                        email = "f3rreirahugo@hotmail.com",
                        url = "https://www.linkedin.com/in/hugo-de-fran%C3%A7a-torres-5a9058287/"
                )
        )
)
public class OpenApiConfiguration {
}
