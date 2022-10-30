package com.java.recode.domain.auth.service;

import com.java.recode.domain.auth.presentation.dto.req.LoginRequestDto;
import com.java.recode.domain.auth.presentation.dto.res.TokenResponseDto;
import com.java.recode.domain.user.domain.User;
import com.java.recode.domain.user.facade.UserFacade;
import com.java.recode.global.security.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LoginService {

    private final UserFacade userFacade;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public TokenResponseDto login(LoginRequestDto loginReq) {
        User user = userFacade.getUserByEmail(loginReq.getEmail());
        user.matchedPassword(passwordEncoder, user, loginReq.getPassword());

        // TODO
        String accessToken = jwtProvider.generatedAccessToken(user.getEmail());
        String refreshToken = jwtProvider.generatedRefreshToken(user.getEmail());

        return TokenResponseDto.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .accessTokenExpiredAt(jwtProvider.getExpiredTime())
                .build();
    }
}
