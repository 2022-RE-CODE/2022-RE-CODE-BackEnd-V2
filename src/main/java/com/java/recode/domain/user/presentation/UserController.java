package com.java.recode.domain.user.presentation;

import com.java.recode.domain.user.presentation.dto.req.SignUpUserRequestDto;
import com.java.recode.domain.user.presentation.dto.req.UpdateUserRequestDto;
import com.java.recode.domain.user.presentation.dto.res.UserResponseDto;
import com.java.recode.domain.user.service.UserService;
import com.java.recode.global.annotation.Timer;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Timer
    @PostMapping
    public void join(@RequestBody @Valid SignUpUserRequestDto req) {
        userService.signUp(req);
    }

    @Timer
    @GetMapping
    public UserResponseDto getUser() {
        return userService.getCurrentUser();
    }

    @Timer
    @GetMapping("/{userId}")
    public UserResponseDto getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @Timer
    @GetMapping("/nickname")
    public UserResponseDto getUserByNickname(
            @RequestParam("nickname") String nickname
    ) {
        return userService.getUserByNickname(nickname);
    }

    @Timer
    @PutMapping
    public UserResponseDto updateUser(@RequestBody @Valid UpdateUserRequestDto req) {
        return userService.updateMe(req);
    }

}
