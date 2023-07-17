package it.gaetano.fattura.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {
	
	@Value("${spring.allowed.origin}") 
	private String allowedOrigin;
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
			// TODO Auto-generated method stub
			registry.addMapping("/**")
					.allowedOrigins(allowedOrigin);
			}
		};
	}
}
