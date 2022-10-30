package com.java.recode.domain.user.service;

import com.java.recode.domain.user.domain.User;
import com.java.recode.domain.user.facade.UserFacade;
import com.java.recode.domain.user.presentation.dto.req.SignUpUserRequestDto;
import com.java.recode.domain.user.presentation.dto.res.UserResponseDto;
import com.java.recode.domain.user.verifier.CreateUserVerifier;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class UserService {

    private final UserFacade userFacade;

    @Transactional
    public void signUp(SignUpUserRequestDto req) {
        User user = userFacade.createUser(req.toEntity());
        CreateUserVerifier.nullToEmptyString(user);
    }

    public UserResponseDto getCurrentUser() {
        return new UserResponseDto(userFacade.getCurrentUser());
    }

    public UserResponseDto getUserByUserId(Long id) {
        return new UserResponseDto(userFacade.findUserByUserId(id));
    }
}
