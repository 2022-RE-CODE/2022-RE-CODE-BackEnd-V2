package com.java.recode.domain.user.presentation.api;

import com.java.recode.domain.user.presentation.dto.req.SignUpUserReq;
import com.java.recode.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public void join(@RequestBody SignUpUserReq req) {
        userService.signUp(req);
    }
}
