package club.iotech.openwt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfiguration  extends WebSecurityConfigurerAdapter {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins(
                                "http://localhost:8080",
                                "http://iotech.club")
                        .allowedMethods("PUT", "DELETE", "GET", "POST");
            }
        };
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // all routes protected
        http.authorizeRequests()
                .anyRequest().authenticated()
                // enable OAuth2/OIDC
                .and()
                .oauth2Login();
    }
}