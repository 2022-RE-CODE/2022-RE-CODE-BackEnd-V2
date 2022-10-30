package com.java.recode.global.security.jwt.exception;

import com.java.recode.global.error.exception.ErrorCode;
import com.java.recode.global.error.exception.ReCodeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class InvalidJwtException extends ReCodeException {

    public static final ReCodeException EXCEPTION = new InvalidJwtException();

    public InvalidJwtException() {
        super(ErrorCode.INVALID_TOKEN);
    }
}
