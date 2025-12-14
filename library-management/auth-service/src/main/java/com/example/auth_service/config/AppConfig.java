package com.example.auth_service.config;

import com.example.common.jwt.JwtService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfig {
@Bean
public JwtService jwtService(
String secret,
Seconds}") long expirationSeconds) {
 new JwtService(secret, expirationSeconds);
}

@Bean
public PasswordEncoder passwordEncoder() {
 new BCryptPasswordEncoder();
}
}
