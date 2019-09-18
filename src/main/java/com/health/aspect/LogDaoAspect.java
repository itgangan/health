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

    @Around(value = "dao()")
    public void around(ProceedingJoinPoint joinPoint) {
        logAround(joinPoint);
    }

   
}
