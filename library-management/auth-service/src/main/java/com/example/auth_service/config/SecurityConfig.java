package com.example.auth_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
@Bean
SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
-> csrf.disable());
uests(auth -> auth.anyRequest().permitAll());
 http.build();
}
}
