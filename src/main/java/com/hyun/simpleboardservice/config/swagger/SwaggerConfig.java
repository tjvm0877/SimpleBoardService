package com.hyun.simpleboardservice.config.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI simpleBoardService() {
        Info info = new Info()
                .title("SimpleBoardService API")
                .description("간단한 게시판 API명세서");

        return new OpenAPI().info(info);
    }
}
