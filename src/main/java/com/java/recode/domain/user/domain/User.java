package com.java.recode.domain.user.domain;

import com.java.recode.domain.user.domain.type.Position;
import com.java.recode.domain.user.domain.type.Role;
import com.java.recode.global.entity.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

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
    @Size(max = 8)
    @Enumerated(STRING)
    private Role role;

    @NotNull
    @Size(max = 8)
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

}