package com.java.recode.domain.user.facade;

import com.java.recode.domain.user.domain.User;
import com.java.recode.domain.user.domain.repository.UserRepository;
import com.java.recode.domain.user.exception.UserNotFoundException;
import com.java.recode.domain.user.verifier.CreateUserVerifier;
import com.java.recode.global.security.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final CreateUserVerifier createUserVerifier;

    public User createUser(User user) {
        createUserVerifier.alreadyExistsUserVerifier(user);
        user.encodePassword(passwordEncoder);
        return userRepository.save(user);
    }

    public User getCurrentUser() {
        return SecurityUtil.getCurrentUser().getUser();
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public User findUserByUserId(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}
