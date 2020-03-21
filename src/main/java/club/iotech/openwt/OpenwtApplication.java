package club.iotech.openwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class OpenwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenwtApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry
					.addMapping("/boat")
					.allowedOrigins(
							"http://iotech.club",	// PROD
							"http://localhost:8080"		// DEV
					);
			}
		};
	}
}
