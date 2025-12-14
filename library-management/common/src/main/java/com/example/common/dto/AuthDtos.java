package com.example.common.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class AuthDtos {
public static class UserRegisterRequest {
otBlank
String username;
otBlank
 = 6)
String password;
}

public static class AdminRegisterRequest {
otBlank
(regexp = "^\\+?[0-9]{10,15}$", message = "Invalid mobile number")
String mobile;
}

public static class OtpVerifyRequest {
otBlank
String mobile;
otBlank
(regexp = "^[0-9]{6}$", message = "Invalid OTP format")
String otp;
}

public static class LoginRequest {
otBlank
String username;
otBlank
String password;
}

public static class JwtResponse {
String token;
String role;
String username;
}
}
