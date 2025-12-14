package com.example.auth_service.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
public class User {
@Id
private String id;
private String username;
private String passwordHash;
private String mobile;
private String role; // ADMIN or USER
private String otp;
private Instant otpExpiry;
private List<String> borrowedIsbns = new ArrayList<>();

public String getId() { return id; }
public void setId(String id) { this.id = id; }
public String getUsername() { return username; }
public void setUsername(String username) { this.username = username; }
public String getPasswordHash() { return passwordHash; }
public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }
public String getMobile() { return mobile; }
public void setMobile(String mobile) { this.mobile = mobile; }
public String getRole() { return role; }
public void setRole(String role) { this.role = role; }
public String getOtp() { return otp; }
public void setOtp(String otp) { this.otp = otp; }
public Instant getOtpExpiry() { return otpExpiry; }
public void setOtpExpiry(Instant otpExpiry) { this.otpExpiry = otpExpiry; }
public List<String> getBorrowedIsbns() { return borrowedIsbns; }
public void setBorrowedIsbns(List<String> borrowedIsbns) { this.borrowedIsbns = borrowedIsbns; }
}
