package com.health.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

public class LogAspect {
    private static final Logger logger = LoggerFactory.getLogger("accessLog");

    void logBefore(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();

        logger.info("session:{} {}.{} begins with:{}", new Object[]{session.getId(), className, methodName, args});
    }

    void logAfterReturning(JoinPoint joinPoint, Object result) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();

        logger.info("session:{} {}.{} end with:{} result:{}", new Object[]{session.getId(), className, methodName, args, result});
    }

    Object logAround(ProceedingJoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        Object[] args = joinPoint.getArgs();

        logger.info("session:{} {}.{} begins with:{}", new Object[]{session.getId(), className, methodName, args});

        Object obj = null;
        long startTime = System.currentTimeMillis();

        try {
            obj = joinPoint.proceed(args);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

        long endTime = System.currentTimeMillis();

        logger.info("session:{} {}.{} end with:{} cost:{} mills. result:{}", new Object[]{session.getId(), className, methodName, args, (endTime - startTime), obj});
        return obj;
    }

    void logAfterThrowing(JoinPoint joinPoint, ArithmeticException exception) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();

        logger.error("Exception in {} {}, e:{}", new Object[]{className, methodName, exception});
        logger.error("Exception ", exception);
    }


}
