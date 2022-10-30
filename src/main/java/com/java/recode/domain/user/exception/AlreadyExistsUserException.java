package com.java.recode.domain.user.exception;

import com.java.recode.global.error.exception.ErrorCode;
import com.java.recode.global.error.exception.ReCodeException;

public class AlreadyExistsUserException extends ReCodeException {

    public static final ReCodeException EXCEPTION = new AlreadyExistsUserException();

    public AlreadyExistsUserException() {
        super(ErrorCode.ALREADY_EXISTS_USER);
    }
}
