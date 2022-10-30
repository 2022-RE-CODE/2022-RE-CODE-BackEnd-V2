package com.java.recode.domain.user.exception;

import com.java.recode.global.error.exception.ErrorCode;
import com.java.recode.global.error.exception.ReCodeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.*;

@ResponseStatus(NOT_FOUND)
public class UserNotFoundException extends ReCodeException {

    public static final ReCodeException EXCEPTION =
            new UserNotFoundException();

    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
