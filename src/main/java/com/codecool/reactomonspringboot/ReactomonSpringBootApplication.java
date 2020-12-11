package com.codecool.reactomonspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ReactomonSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactomonSpringBootApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/pokemon").allowedOrigins("http://localhost:3000");
				registry.addMapping("/pokemon/{id}").allowedOrigins("http://localhost:3000");
				registry.addMapping("/type").allowedOrigins("http://localhost:3000");
			}
		};
	}

}
