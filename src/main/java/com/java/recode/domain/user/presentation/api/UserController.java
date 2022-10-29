package com.java.recode.domain.user.presentation.api;

import com.java.recode.domain.user.presentation.dto.req.SignUpUserRequestDto;
import com.java.recode.domain.user.presentation.dto.res.UserResponseDto;
import com.java.recode.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public void join(@RequestBody SignUpUserRequestDto req) {
        userService.signUp(req);
    }

    @GetMapping
    public UserResponseDto getUser() {
        return userService.getCurrentUser();
    }
}
