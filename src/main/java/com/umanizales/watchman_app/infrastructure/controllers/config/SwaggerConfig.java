package com.umanizales.watchman_app.infrastructure.controllers.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

//una vez se prenda la aplicacion se ejecuta esto
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    //crear un objeto docket(espacio de documentacion de swagger) (interfaz grafica que permite probar los metodos que tiene la aplicacion)
    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("WatchmanController")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.umanizales.watchman_app.infrastructure.controllers"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Controller Manage Watchman",
                "Service Rest API Crud WatchmanApp",
                "1.0",
                "https://github.com/marcelaTrujilloToro",
                new Contact("Marcela Trujillo Toro", "https://github.com/marcelaTrujilloToro", "marces0410@hotmail.com"),
                "LICENSE",
                "LICENSE URL",
                Collections.emptyList()
        );
    }
}
