package com.health.exception;

import com.google.common.collect.ImmutableMap;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.WebRequest;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 通用Controller异常处理
 */
@ControllerAdvice
public class AppExceptionHandler {

    @Inject
    private Logger logger;

    private static final String ERROR_MSG = "errorMsg";
    private static final Map<Class, String> ERROR_MSG_MAP = ImmutableMap.of(
            NullPointerException.class, "服务器异常，稍后再试！",
            IllegalArgumentException.class, "参数错误！",
            Exception.class, "服务器异常，稍后再试！"
    );

    @ExceptionHandler(NullPointerException.class)
    public String nullPointExceptionHandler(final Exception ex) {
        return exceptionHandler(NullPointerException.class, ex);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String illegalArgumentExceptionHandler(Exception ex) {
        return exceptionHandler(IllegalArgumentException.class, ex);
    }

    @ExceptionHandler({Exception.class})
    public String ExceptionHandler(Exception ex) {
        return exceptionHandler(Exception.class, ex);
    }

    private String exceptionHandler(Class clazz, Exception ex) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        request.setAttribute(ERROR_MSG, ERROR_MSG_MAP.get(clazz));
        logger.error("exception", ex);
        return "error";
    }

}
