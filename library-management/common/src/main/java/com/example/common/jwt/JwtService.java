package com.example.common.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.time.Instant;
import java.util.Date;
import java.util.Map;

public class JwtService {
private final Key signingKey;
private final long expirationSeconds;

public JwtService(String secret, long expirationSeconds) {
ingKey = Keys.hmacShaKeyFor(secret.getBytes());
Seconds = expirationSeconds;
}

public String generateToken(String subject, String role, Map<String, Object> extraClaims) {
stant now = Instant.now();
 Jwts.builder()
role)
ow))
(Date.from(now.plusSeconds(expirationSeconds)))
With(signingKey, SignatureAlgorithm.HS256)
Claims parseClaims(String token) {
 Jwts.parserBuilder()
ingKey(signingKey)
)
();
}

public boolean isTokenValid(String token, String expectedSubject) {
claims = parseClaims(token);
 expectedSubject.equals(claims.getSubject()) && claims.getExpiration().after(new Date());
}

public String extractRole(String token) {
 parseClaims(token).get("role", String.class);
}
}
