package com.coopeuch;

import io.swagger.annotations.License;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
public class ComponenteCoopeuchApiuxApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComponenteCoopeuchApiuxApplication.class, args);
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("ComponenteCoopeuchApiux-------")
                        .version("0.11")
                        .description("Prueba de proyecto Coopeuch")
                        .termsOfService("http://swagger.io/terms/"));

    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
            }
        };
    }

}
