package com.java.recode.global.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ReCodeException extends RuntimeException{
    private final ErrorCode errorCode;
}
