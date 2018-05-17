package com.health.init.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class LoggerConfig {

    @Bean
    @Scope("prototype")
    Logger logger(InjectionPoint injectionPoint) {
//        return LoggerFactory.getLogger(injectionPoint.getMethodParameter().getContainingClass());
        if (injectionPoint == null) {
            System.err.println("injectionPoint is null.");
        }else if (injectionPoint.getMember() == null){
            System.err.println("member is null.");
        }
        return LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass());
    }
}
