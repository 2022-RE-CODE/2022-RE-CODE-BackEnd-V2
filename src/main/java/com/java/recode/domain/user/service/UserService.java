package com.java.recode.domain.user.service;

import com.java.recode.domain.user.facade.UserFacade;
import com.java.recode.domain.user.presentation.dto.req.SignUpUserReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class UserService {

    private final UserFacade userFacade;

    @Transactional
    public void signUp(SignUpUserReq req) {
        userFacade.createUser(req.toEntity());
    }
}
