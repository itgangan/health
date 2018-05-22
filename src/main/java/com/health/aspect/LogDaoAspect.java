package com.health.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogDaoAspect extends LogAspect {

    @Pointcut("execution(* com.health.dao.*.*(..))")
    private void dao() {
    }

//    @Before("dao()")
//    public void before(JoinPoint joinPoint) {
//        logBefore(joinPoint);
//    }

//    @AfterReturning(value = "dao()", returning = "result")
//    public void afterReturning(JoinPoint joinPoint, Object result) {
//        logAfterReturning(joinPoint, result);
//    }

    @Around(value = "dao()")
    public void around(ProceedingJoinPoint joinPoint) {
        logAround(joinPoint);
    }

    @AfterThrowing(value = "dao()", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, ArithmeticException exception) {
        logAfterThrowing(joinPoint, exception);
    }
}
