package com.health.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogControllerAspect extends LogAspect{

    @Pointcut("execution(* com.health.controller.*.*(..))")
    private void controller(){}

    @Before("controller()")
    public void before(JoinPoint joinPoint){
        logBefore(joinPoint);
    }
    @AfterReturning(value="controller()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){
        logAfterReturning(joinPoint, result);
    }

    @AfterThrowing(value = "controller()", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, ArithmeticException exception) {
        logAfterThrowing(joinPoint, exception);
    }

}
