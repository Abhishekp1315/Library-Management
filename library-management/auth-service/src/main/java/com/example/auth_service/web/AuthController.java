package com.example.auth_service.web;

import com.example.common.dto.AuthDtos;
import com.example.auth_service.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
private final AuthService authService;
public AuthController(AuthService authService) { this.authService = authService; }

@PostMapping("/register-user")
public ResponseEntity<?> registerUser(@Valid @RequestBody AuthDtos.UserRegisterRequest request) {
uest);
 ResponseEntity.ok().body("User registered");
}

@PostMapping("/login")
public ResponseEntity<AuthDtos.JwtResponse> login(@Valid @RequestBody AuthDtos.LoginRequest request) {
g token = authService.login(request);
se res = new AuthDtos.JwtResponse();
 = token;
= "USER";
ame = request.username;
 ResponseEntity.ok(res);
}

@PostMapping("/register-admin")
public ResponseEntity<?> registerAdmin(@Valid @RequestBody AuthDtos.AdminRegisterRequest request) {
Initiate(request);
 ResponseEntity.ok().body("OTP sent (check server logs) ");
}

@PostMapping("/verify-otp")
public ResponseEntity<AuthDtos.JwtResponse> verifyOtp(@Valid @RequestBody AuthDtos.OtpVerifyRequest request) {
g token = authService.verifyOtp(request);
se res = new AuthDtos.JwtResponse();
 = token;
= "ADMIN";
ame = request.mobile;
 ResponseEntity.ok(res);
}
}
