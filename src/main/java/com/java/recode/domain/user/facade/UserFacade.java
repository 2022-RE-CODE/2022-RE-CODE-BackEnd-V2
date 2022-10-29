package com.java.recode.domain.user.facade;

import com.java.recode.domain.user.domain.User;
import com.java.recode.domain.user.domain.repository.UserRepository;
import com.java.recode.domain.user.verifier.CreateUserVerifier;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final UserRepository userRepository;
    private final CreateUserVerifier createUserVerifier;

    public void createUser(User user) {
        createUserVerifier.alreadyExistsUserVerifier(user);
        userRepository.save(user);
    }
}
