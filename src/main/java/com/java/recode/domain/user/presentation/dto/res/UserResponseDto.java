package com.java.recode.domain.user.presentation.dto.res;

import com.java.recode.domain.user.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserResponseDto {

    private Long userId;
    private String nickname;
    private String role;
    private String roles;
    private String position;
    private String gitLink;
    private String blogLink;
    private String img;

    public UserResponseDto(User user) {
        this.userId = user.getId();
        this.nickname = user.getNickname();
        this.role = user.getRole().name();
        this.gitLink = user.getGitLink();
        this.blogLink = user.getBlogLink();
        this.roles = user.getRole().name();
        this.position = user.getPosition().name();
        this.img = user.getImgUrl();
    }

}
