package com.java.recode.domain.user.exception;

import com.java.recode.global.error.exception.ErrorCode;
import com.java.recode.global.error.exception.ReCodeException;

public class UserNotFoundException extends ReCodeException {

    public static final ReCodeException EXCEPTION =
            new UserNotFoundException();

    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
