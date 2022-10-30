package com.java.recode.domain.user.domain;

import com.java.recode.domain.user.domain.type.Position;
import com.java.recode.domain.user.domain.type.Role;
import com.java.recode.global.entity.BaseTimeEntity;
import com.java.recode.global.error.exception.ErrorCode;
import com.java.recode.global.error.exception.ReCodeException;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static javax.persistence.EnumType.*;
import static javax.persistence.GenerationType.*;
import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Entity
@DynamicInsert
@DynamicUpdate
@Table(uniqueConstraints = {
        @UniqueConstraint(
                name = "user_uk",
                columnNames = {"email", "gitLink", "blogLink", "imgPath", "imgUrl"}
        )
})
public class User extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 32)
    private String email;

    @NotNull
    @Size(max = 16)
    private String nickname;

    @NotNull
    @Size(max = 64)
    private String password;

    @NotNull
    @Column(length = 8)
    @Enumerated(STRING)
    private Role role;

    @NotNull
    @Column(length = 8)
    @Enumerated(STRING)
    private Position position;

    @Size(max = 128)
    @Column
    private String gitLink;

    @Size(max = 128)
    @Column
    private String blogLink;

    @Size(max = 128)
    @Column
    private String imgPath;

    @Size(max = 128)
    @Column
    private String imgUrl;

    @Builder
    public User(String email, String nickname, String password, Role role, Position position, String gitLink, String blogLink, String imgPath, String imgUrl) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.role = role;
        this.position = position;
        this.gitLink = gitLink;
        this.blogLink = blogLink;
        this.imgPath = imgPath;
        this.imgUrl = imgUrl;
    }

    // auth TODO : Validate 클래스로 분리하고 싶음
    public void encodePassword(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(password);
    }

    public void matchedPassword(PasswordEncoder passwordEncoder, User user, String password) {
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new ReCodeException(ErrorCode.NOT_MATCH_PASSWORD);
        }
    }
}