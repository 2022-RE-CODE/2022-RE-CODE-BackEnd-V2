package com.java.recode.domain.user.presentation;

import com.java.recode.domain.user.presentation.dto.req.SignUpUserRequestDto;
import com.java.recode.domain.user.presentation.dto.req.UpdateUserRequestDto;
import com.java.recode.domain.user.presentation.dto.res.UserResponseDto;
import com.java.recode.domain.user.service.UserService;
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

    @PostMapping
    public void join(@RequestBody @Valid SignUpUserRequestDto req) {
        userService.signUp(req);
    }

    @GetMapping
    public UserResponseDto getUser() {
        return userService.getCurrentUser();
    }
    
    @GetMapping("/{userId}")
    public UserResponseDto getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/nickname")
    public UserResponseDto getUserByNickname(
            @RequestParam("nickname") String nickname
    ) {
        return userService.getUserByNickname(nickname);
    }

    @PutMapping
    public UserResponseDto updateUser(@RequestBody @Valid UpdateUserRequestDto req) {
        return userService.updateMe(req);
    }

}
