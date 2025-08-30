package org.engripaye.librarymanagementsystem.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI libraryManagementOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Library Management System API")
                        .description("REST API documentation for the Library Management System project")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Ipaye Babatunde")
                                .email("b.tunde.ipaye@gmail.com")
                                .url("https://github.com/engripaye"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://springdoc.org")));
    }
}
