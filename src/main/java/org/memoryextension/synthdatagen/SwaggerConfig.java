package org.memoryextension.synthdatagen;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
		return new OpenAPI().info(new Info().title("SyntheticDataGenerator")
			.description("SyntheticDataGenerator application")
			.version("v0.5.8"));
			// go to /swagger-ui.html
    }
}
