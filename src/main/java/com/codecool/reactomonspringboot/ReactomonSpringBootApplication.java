package com.codecool.reactomonspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ReactomonSpringBootApplication {

	private static final String REACT_APP_URL = "https://reactomon-spring-backend.netlify.app";

	public static void main(String[] args) {
		SpringApplication.run(ReactomonSpringBootApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/pokemon").allowedOrigins(REACT_APP_URL);
				registry.addMapping("/pokemon/{id}").allowedOrigins(REACT_APP_URL);
				registry.addMapping("/pokemon/image/{id}").allowedOrigins(REACT_APP_URL);
				registry.addMapping("/type").allowedOrigins(REACT_APP_URL);
			}
		};
	}

}
