package com.health.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    /**
     * 环绕切面，功能为打印方法的入参，执行时间，还回结果，同时将运行时异常封装SaeException并抛出
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        logger.info("{}.{} begin with:{}", className, methodName, args);

        long startTime = System.currentTimeMillis();
        Object obj = joinPoint.proceed(args);
        long endTime = System.currentTimeMillis();

        logger.info("{}.{} end with:{} cost:{} mills. result:{}", className, methodName, args, (endTime - startTime),
                obj);
        return obj;

    }

    /**
     * 当抛异常之后的处理逻辑
     *
     * @param joinPoint
     * @param ex
     */
    void logAfterThrowing(JoinPoint joinPoint, Exception ex) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        logger.error("Exception in {}.{}({})", className, methodName, args, ex);
    }


}
