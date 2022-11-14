package com.java.recode.domain.user.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Slf4j
@Aspect
@Component
public class LoggingUser {

    @Pointcut("execution(* com.java.recode.domain.user.presentation..*.*(..))")
    private void pointCut() {}

    @Pointcut("@annotation(com.java.recode.global.annotation.Timer)")
    private void timerPointCut() {}

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        log.info("API Name : {}", method.getName());

        Object[] args = joinPoint.getArgs();

        for (Object obj : args) {
            log.info("Parameter Type : {}", obj.getClass().getSimpleName());
            log.info("Value : {}", obj);
        }
    }

    @AfterReturning(value = "pointCut()", returning = "returnValue")
    public void afterRunning(JoinPoint joinPoint, Object returnValue) {
        log.info("Returned Method : {}", returnValue);
    }
}
