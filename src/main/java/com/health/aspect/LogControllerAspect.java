package com.health.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class LogControllerAspect extends LogAspect {

    @Pointcut("execution(* com.health.controller.*.*(..))")
    private void controller() {
    }

//    @Before("controller()")
//    public void before(JoinPoint joinPoint) {
//        logBefore(joinPoint);
//    }

//    @AfterReturning(value = "controller()", returning = "result")
//    public void afterReturning(JoinPoint joinPoint, Object result) {
//        logAfterReturning(joinPoint, result);
//    }

    @Around(value = "controller()")
    public void around(ProceedingJoinPoint joinPoint) {
        logAround(joinPoint);
    }

    @AfterThrowing(value = "controller()", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, ArithmeticException exception) {
        logAfterThrowing(joinPoint, exception);
    }

}
