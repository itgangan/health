package com.health.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogServiceAspect extends LogAspect {

    @Pointcut("execution(* com.health..service.*.*(..))")
    private void service() {
    }

    @Around(value = "service()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        logAround(joinPoint);
    }


}
