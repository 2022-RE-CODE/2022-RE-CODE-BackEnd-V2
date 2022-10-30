package com.java.recode.global.security.jwt.exception;

import com.java.recode.global.error.exception.ErrorCode;
import com.java.recode.global.error.exception.ReCodeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class ExpiredJwtException extends ReCodeException {

    public static final ReCodeException EXCEPTION =
            new ExpiredJwtException();

    private ExpiredJwtException() {
        super(ErrorCode.EXPIRED_TOKEN);
    }

}
