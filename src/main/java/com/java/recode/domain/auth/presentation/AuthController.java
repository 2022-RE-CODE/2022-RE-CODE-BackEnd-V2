package com.java.recode.domain.auth.presentation;

import com.java.recode.domain.auth.presentation.dto.req.LoginRequestDto;
import com.java.recode.domain.auth.presentation.dto.res.TokenResponseDto;
import com.java.recode.domain.auth.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Validated // AOP 기반으로 유효성 검증을 위한 인터셉터 등록 - 클래스 단위 검증
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final LoginService loginService;

    @PostMapping("/login")
    public TokenResponseDto login(@RequestBody @Valid LoginRequestDto loginReq) {
        return loginService.login(loginReq);
    }

}
