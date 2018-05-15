package com.health.aspect;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

public class LogAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    public void logBefore(JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());

        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();

        logger.info("sessionid:{} {}.{} begins with:{}", new Object[]{session.getId(), className, methodName, args});
    }

    public void logAfterReturning(JoinPoint joinPoint, Object result){
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();

        logger.info("sessionid:{} {}.{} end with:{} result:{}", new Object[] { session.getId(), className, methodName, args, result });
    }

    public void logAfterThrowing(JoinPoint joinPoint, ArithmeticException exception) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();

        logger.error("Exception in {} {}, e:{}", new Object[] { className, methodName, exception });
        logger.error("Exception ", exception);
    }
}
