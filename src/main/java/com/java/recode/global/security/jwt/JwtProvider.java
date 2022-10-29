package com.java.recode.global.security.jwt;

import com.java.recode.domain.auth.domain.repository.RefreshTokenRepository;
import com.java.recode.global.security.auth.AuthDetailsService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtProvider {

    private final JwtProperties jwtProperties;
    private final AuthDetailsService authDetailsService;
    private final RefreshTokenRepository refreshTokenRepository;

    private String generatedToken(String id, Long exp) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
                .setSubject(id)
                .claim("type", "access")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + exp * 1000))
                .compact();
    }

    public String generatedAccessToken(String id) {
        return generatedToken(id, jwtProperties.getAccessExp());
    }

    public String generatedRefreshToken(String id) {
        return generatedToken(id, jwtProperties.getRefreshExp());
    }

}
