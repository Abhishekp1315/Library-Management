package com.example.auth_service.service;

import com.example.auth_service.domain.User;
import com.example.auth_service.repo.UserRepository;
import com.example.common.dto.AuthDtos;
import com.example.common.jwt.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

@Service
public class AuthService {
private final UserRepository userRepository;
private final PasswordEncoder passwordEncoder;
private final JwtService jwtService;
private final Random random = new Random();

public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
 = userRepository;
coder = passwordEncoder;
= jwtService;
}

public void registerUser(AuthDtos.UserRegisterRequest request) {
.findByUsername(request.username).ifPresent(u -> { throw new RuntimeException("Username already exists"); });
user = new User();
ame(request.username);
coder.encode(request.password));
.save(user);
}

public String login(AuthDtos.LoginRequest request) {
user = userRepository.findByUsername(request.username).orElseThrow(() -> new RuntimeException("Invalid credentials"));
(!passwordEncoder.matches(request.password, user.getPasswordHash())) {
new RuntimeException("Invalid credentials");
g, Object> claims = new HashMap<>();
ame", user.getUsername());
 jwtService.generateToken(user.getUsername(), user.getRole(), claims);
}

public void registerAdminInitiate(AuthDtos.AdminRegisterRequest request) {
al<User> existing = userRepository.findByMobile(request.mobile);
admin = existing.orElseGet(User::new);
.setMobile(request.mobile);
.setRole("ADMIN");
g otp = String.format("%06d", random.nextInt(1_000_000));
.setOtp(otp);
.setOtpExpiry(Instant.now().plusSeconds(300));
.save(admin);
stem.out.println("OTP for " + request.mobile + ": " + otp);
}

public String verifyOtp(AuthDtos.OtpVerifyRequest request) {
admin = userRepository.findByMobile(request.mobile).orElseThrow(() -> new RuntimeException("Admin not found"));
(admin.getOtp() == null || admin.getOtpExpiry() == null) {
new RuntimeException("OTP not requested");
(Instant.now().isAfter(admin.getOtpExpiry())) {
new RuntimeException("OTP expired");
(!admin.getOtp().equals(request.otp)) {
new RuntimeException("Invalid OTP");
.setOtp(null);
.setOtpExpiry(null);
.save(admin);
g, Object> claims = new HashMap<>();
admin.getMobile());
 jwtService.generateToken(admin.getMobile(), admin.getRole(), claims);
}
}
