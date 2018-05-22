package com.health.init.spring;

import com.health.init.app.SystemConstans;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

/**
 * 我们希望DispatcherServlet加载包含Web组件的bean，如控制器、视图解析器以及处理器映射，
 * 而ContextLoaderListener要加载应用中其它的bean，这些bean通常是驱动应用后端的中间层和数据层组件
 *
 * @author ganxiangyong
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        // 返回带有@Configuration注解的类将会用来配置ContextLoaderListener创建的应用上下文中的bean
        return new Class<?>[]{RootConfig.class, AspectConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // 返回带有@Configuration注解的类将会用来定义DispatcherServlet应用上下文中的bean
        // 注意：这里的AspectConfig.class必须放在这里，只有放在DispatcherServlet应用上下文中，对Controller的切入才能生效，要不然AspectConfig找不到Controller
        return new Class<?>[]{ServletConfig.class};
    }

    @Override
    protected void customizeRegistration(Dynamic registration) {
		registration.setMultipartConfig(new MultipartConfigElement(SystemConstans.UPLOAD_TEMP));
        registration.setLoadOnStartup(1);
        registration.setInitParameter("name", "value");
    }

    @Override
    protected Filter[] getServletFilters() {
        return super.getServletFilters();
    }

}
