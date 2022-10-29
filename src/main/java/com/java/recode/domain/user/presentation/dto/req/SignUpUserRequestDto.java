package com.java.recode.domain.user.presentation.dto.req;

import com.java.recode.domain.user.domain.User;
import com.java.recode.domain.user.domain.type.Position;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import static com.java.recode.domain.user.domain.type.Role.*;

@Getter
public class SignUpUserRequestDto {

    @NotBlank(message = "이메일은 필수 입력 값입니다.")
    @Email(message = "이메일 형식에 맞지 않습니다.")
    private final String email;

//    @NotBlank(message = "이메일 인증 코드는 필수 입력 값입니다.")
//    private final String checkEmailCode;

    @NotBlank(message = "닉네임은 필수 입력 값입니다.")
    private final String nickname;

    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Pattern(regexp="(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}",
            message = "비밀번호는 영문 대,소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 8자 ~ 20자의 비밀번호여야 합니다.")
    private final String password;
    private final String checkPassword;
    private final String position;

    public SignUpUserRequestDto(String email, String nickname, String password, String checkPassword, String position) {
        this.email = email;
//        this.checkEmailCode = checkEmailCode;
        this.nickname = nickname;
        this.password = password;
        this.checkPassword = checkPassword;
        this.position = position;
    }

    @Builder
    public User toEntity(){
        return User.builder()
                .email(email)
                .nickname(nickname)
                .password(password)
                .position(Position.valueOf(position))
                .role(USER)
                .build();
    }

}
