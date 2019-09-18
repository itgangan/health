package com.health.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogControllerAspect extends LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogControllerAspect.class);

    /**
     * 切点
     */
    @Pointcut("execution(* com.health.controller.*.*(..))")
    private void controller() {
    }

    /**
     * 通知，统一处理异常
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around(value = "controller()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object obj = null;
        try {
            obj = logAround(joinPoint);
        } catch (Exception throwable) {
            logger.error("exception ", throwable);
            // 这里应该捕获特定的异常并处理
            throw throwable;
        }

        return obj;

    }

    /**
     * 当抛出异常后的处理逻辑
     *
     * @param joinPoint
     * @param exception
     */
    @AfterThrowing(value = "controller()", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Exception exception) {
        logAfterThrowing(joinPoint, exception);
    }

}
