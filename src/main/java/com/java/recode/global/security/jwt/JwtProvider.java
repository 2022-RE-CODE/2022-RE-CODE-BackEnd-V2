package com.java.recode.global.security.jwt;

import com.java.recode.domain.auth.domain.repository.RefreshTokenRepository;
import com.java.recode.global.security.auth.AuthDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtProvider {

    private final JwtProperties jwtProperties;
    private final AuthDetailsService authDetailsService;
    private final RefreshTokenRepository refreshTokenRepository;

}
