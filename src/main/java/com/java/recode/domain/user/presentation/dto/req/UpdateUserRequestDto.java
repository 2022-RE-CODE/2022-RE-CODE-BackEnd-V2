package com.java.recode.domain.user.presentation.dto.req;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UpdateUserRequestDto {

    private final String nickname;
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
