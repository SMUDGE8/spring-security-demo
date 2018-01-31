package com.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;

/**
 * @author lei
 * @since 2018/1/30
 */
@Configurable
@EnableWebMvc //启用spring mvc
@ComponentScan(basePackages = "com.controller") //启用组件扫描
public class ServletConfig extends WebMvcConfigurerAdapter{
   /* @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        //处理中文乱码问题
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastConverter.setSupportedMediaTypes(fastMediaTypes);
        fastConverter.setFastJsonConfig(fastJsonConfig);
        converters.add(fastConverter);
    }*/
    /**
     * Thymeleaf视图解析器
     *
     * @param springTemplateEngine
     * @return
     */
    /*@Bean
    public ThymeleafViewResolver viewResolver(SpringTemplateEngine springTemplateEngine) {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(springTemplateEngine);
        viewResolver.setCharacterEncoding("utf-8");
        return viewResolver;
    }*/
    /**
     * 模版引擎
     *
     * @param iTemplateResolver
     * @return
     */
    /*@Bean
    public SpringTemplateEngine templateEngine(ITemplateResolver iTemplateResolver) {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(iTemplateResolver);
        return templateEngine;
    }*/
    /**
     * Thymeleaf3.0之后
     * Thymeleaf模版解析器
     *
     * @return
     */
    /*@Bean
    public ITemplateResolver iTemplateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setTemplateMode("HTML5");
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML");
        templateResolver.setCharacterEncoding("utf-8");
        templateResolver.setCacheable(false);
        return templateResolver;
    }*/
    /**
     * Thymeleaf3.0之前
     * Thymeleaf模版解析器
     * @return
     */
  /*  @Bean
    public TemplateResolver templateResolver() {
        TemplateResolver resolver = new ServletContextTemplateResolver();
        resolver.setPrefix("/WEB-INF/VIEWS/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML5");
        resolver.setCacheable(false);
        return resolver;
    }*/
    /**
     * 配置静态资源的处理
     * 要求DispatcherServlet将对静态资源的请求转发到Servlet容器中默认的Servlet上
     * 而不是使用DispatcherServlet本身来处理此类请求。
     *
     * @param configurer
     */
   /* @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }*/
    /**
     * 配置视图解析器
     * ==> JSP视图
     *
     * @return
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/pages/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
