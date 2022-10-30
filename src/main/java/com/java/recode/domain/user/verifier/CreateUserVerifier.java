package com.java.recode.domain.user.verifier;

import com.java.recode.domain.user.domain.User;
import com.java.recode.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class CreateUserVerifier {

    private final UserRepository userRepository;

    public void alreadyExistsUserVerifier(User user) {
        userRepository.findAll()
                .forEach(alreadyExistsUser -> {
                    if (Objects.equals(alreadyExistsUser, user)) {
                        throw new IllegalArgumentException("이미 존재하는 회원입니다.");
                    }
                });
    }

    public static void nullToEmptyString(User user) {
        user.updateBlogLink("");
        user.updateGitLink("");
        user.updateImgUrl("");
        user.updateImgPath("");
    }
}
