package com.szpx.config;

import com.szpx.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author lishihui
 * @date 2022/8/4 14:06
 */
@Configuration //代表该类是一个配置类
public class MvcConfig implements WebMvcConfigurer {

    //添加视图控制器
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //发送/index请求到达index页面
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/toAddUser").setViewName("add");
    }

    //激活拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/*")
                .excludePathPatterns("/login","/index");
    }

    /**
     * 放行静态资源
     * 允许static文件下的静态资源使用绝对路径进行访问
     * 如：../img/bg.jpg
     */
    @Configuration
    public class WebConfig implements WebMvcConfigurer {
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            //注册静态资源的处理器，指定statics文件夹的路径
            registry.addResourceHandler("/statics/**").addResourceLocations("classpath:/statics/");
        }
    }

}
