package com.health.init.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = {"com.health"}, excludeFilters = {
        @Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class),
        @Filter(type = FilterType.ANNOTATION, value = EnableAspectJAutoProxy.class)
})
public class RootConfig {

    @Bean
    @Scope("prototype")
    Logger logger(InjectionPoint injectionPoint) {
        return LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass());
    }
}
