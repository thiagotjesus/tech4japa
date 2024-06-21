package br.com.tech4me.tech4japa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Tech4japaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Tech4japaApplication.class, args);
	}

	    @Bean
    public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/produtos/{id}")
                        .allowedOrigins("http://localhost:8080");
			}
		};
	}

}
