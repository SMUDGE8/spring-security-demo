package com.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * @author lei
 * @since 2018/1/30
 */
public class WebAppInitialzer extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * 配置root上下文,如Jpa数据源等等的配置
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class,SecurityConfig.class,DataSourceConfig.class,JpaConfig.class};
    }

    /**
     * 配置dispatcher servlet
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ServletConfig.class};
    }

    /**
     * 将DispatcherServlet映射到 "/"
     * 指定开始被servlet处理的url,配置从/开始
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 这里注册的所有过滤器,都会映射到DispatcherServlet
     * 就是说这里的过滤器过滤规则是 /*
     * 所有的请求都会先到这里注册的过滤器中
     *
     * @return
     */
    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{
                new CharacterEncodingFilter("UTF-8", true)
        };
    }
}