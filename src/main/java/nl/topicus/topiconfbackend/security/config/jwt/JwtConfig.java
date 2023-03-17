package nl.topicus.topiconfbackend.security.config.jwt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {

    @Bean
    public JwtAuthenticationTokenFilter authenticationTokenFilter() throws Exception {
        return new JwtAuthenticationTokenFilter();
    }
}