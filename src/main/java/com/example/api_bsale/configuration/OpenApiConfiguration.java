package com.example.api_bsale.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;

public class OpenApiConfiguration {
    @Bean(name = "bsaleOpenApi")
    public OpenAPI bsaleOpenAPI(){
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Tienda Online - BSALE - API")
                        .description("Tienda Online, test Bsale implementado con Spring boot RESTful service y documentado con spingdoc_openapi y OpenAPI 3.0 "));
    }
}
