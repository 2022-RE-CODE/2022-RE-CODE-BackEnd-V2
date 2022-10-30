package com.java.recode.domain.user.presentation.dto.req;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Pattern;

@Getter
public class UpdateUserRequestDto {

    private final String nickname;

    @Pattern(regexp="(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}",
            message = "비밀번호는 영문 대,소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 8자 ~ 20자의 비밀번호여야 합니다.")
    private final String password;
    private final String position;
    private final String gitLink;
    private final String blogLink;

    @Builder
    public UpdateUserRequestDto(String nickname, String password, String position, String gitLink, String blogLink) {
        this.nickname = nickname;
        this.password = password;
        this.position = position;
        this.gitLink = gitLink;
        this.blogLink = blogLink;
    }

    @Override
    public String toString() {
        return "All Update Items";
    }
}
