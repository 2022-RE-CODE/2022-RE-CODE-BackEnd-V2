package com.java.recode.domain.user.exception;

import com.java.recode.global.error.exception.ErrorCode;
import com.java.recode.global.error.exception.ReCodeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.*;

@ResponseStatus(value = BAD_REQUEST)
public class AlreadyExistsUserException extends ReCodeException {

    public static final ReCodeException EXCEPTION = new AlreadyExistsUserException();

    public AlreadyExistsUserException() {
        super(ErrorCode.ALREADY_EXISTS_USER);
    }
}
