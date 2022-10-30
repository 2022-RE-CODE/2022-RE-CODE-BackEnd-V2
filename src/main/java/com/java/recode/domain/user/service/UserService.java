package com.java.recode.domain.user.service;

import com.java.recode.domain.user.domain.User;
import com.java.recode.domain.user.facade.UserFacade;
import com.java.recode.domain.user.presentation.dto.req.SignUpUserRequestDto;
import com.java.recode.domain.user.presentation.dto.req.UpdateUserRequestDto;
import com.java.recode.domain.user.presentation.dto.res.UserResponseDto;
import com.java.recode.domain.user.verifier.CreateUserVerifier;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class UserService {

    private final UserFacade userFacade;

    @Transactional
    @Cacheable(value = "User", cacheManager = "cacheManager")
    public void signUp(SignUpUserRequestDto req) {
        User user = userFacade.createUser(req.toEntity());
        CreateUserVerifier.nullToEmptyString(user);
    }

    public UserResponseDto getCurrentUser() {
        return new UserResponseDto(userFacade.getCurrentUser());
    }

    @Cacheable(value = "User", key = "#id", cacheManager = "cacheManager")
    public UserResponseDto getUserById(Long id) {
        return new UserResponseDto(userFacade.findUserByUserId(id));
    }

    @Cacheable(value = "User", key = "#nickname", cacheManager = "cacheManager")
    public UserResponseDto getUserByNickname(String nickname) {
        return new UserResponseDto(userFacade.findUserByNickname(nickname));
    }

    @Transactional
    @CachePut(value = "User", cacheManager = "cacheManager")
    public UserResponseDto updateMe(UpdateUserRequestDto req) {
        return new UserResponseDto(userFacade.updateMyAccountInfo(req));
    }

}