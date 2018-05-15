package com.health.exception;

import com.google.common.collect.ImmutableMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 通用Controller异常处理
 */
@ControllerAdvice
public class AppExceptionHandler {

    private static final String ERROR_MSG = "errorMsg";
    private static final Map<Class, String> ERROR_MSG_MAP = ImmutableMap.of(
            NullPointerException.class, "服务器异常，稍后再试！",
            IllegalArgumentException.class, "参数错误！",
            Exception.class, "服务器异常，稍后再试！"
    );

    @ExceptionHandler(NullPointerException.class)
    public String nullPointExceptionHandler() {
        return exceptionHandler(NullPointerException.class);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String illegalArgumentExceptionHandler() {
        return exceptionHandler(IllegalArgumentException.class);
    }

    @ExceptionHandler(Exception.class)
    public String ExceptionHandler(){
        return exceptionHandler(Exception.class);
    }

    private String exceptionHandler(Class clazz) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        request.setAttribute(ERROR_MSG, ERROR_MSG_MAP.get(clazz));
        return "error";
    }

}
