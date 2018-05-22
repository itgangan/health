package com.health.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogServiceAspect extends LogAspect {

    @Pointcut("execution(* com.health..service.*.*(..))")
    private void service() {
    }

//    @Before("service()")
//    public void before(JoinPoint joinPoint) {
//        logBefore(joinPoint);
//    }

//    @AfterReturning(value = "service()", returning = "result")
//    public void afterReturning(JoinPoint joinPoint, Object result) {
//        logAfterReturning(joinPoint, result);
//    }

    @Around(value = "service()")
    public void around(ProceedingJoinPoint joinPoint) {
        logAround(joinPoint);
    }

    @AfterThrowing(value = "service()", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, ArithmeticException exception) {
        logAfterThrowing(joinPoint, exception);
    }
}
