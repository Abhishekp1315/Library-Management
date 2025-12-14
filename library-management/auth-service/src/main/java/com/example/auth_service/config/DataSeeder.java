package com.example.auth_service.config;

import com.example.auth_service.domain.User;
import com.example.auth_service.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataSeeder {
@Bean
CommandLineRunner seedUsers(UserRepository repo, PasswordEncoder encoder) {
 args -> {
dByUsername("testuser").or(() -> {
u = new User();
ame("testuser");
coder.encode("password123"));
 java.util.Optional.of(u);
dByMobile("+15550000001").or(() -> {
a = new User();
");
 java.util.Optional.of(a);
~/library-management
mvn -q -DskipTests package | cat
