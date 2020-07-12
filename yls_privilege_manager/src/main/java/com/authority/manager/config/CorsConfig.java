package com.authority.manager.config;

import com.authority.manager.component.interceptor.AppInterceptorl;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author yls
 * @Date 2020/4/5 9:20
 * @Description 跨域解决方案 cors方案
 * @Version 1.0
 **/
@Configuration
public class CorsConfig implements WebMvcConfigurer {


    /**
     * 功能描述:
     * 〈跨域的配置〉
     * @Author yls
     * @Date 2020/4/12 12:33
     * @param registry cor注册管理
     * @return void
     **/
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") //允许跨域访问的路径
                .allowedOrigins("*") //允许跨域访问的源
                .allowedMethods("POST","GET","PUT","OPTIONS","DELETE") //允许跨域的方法
                .maxAge(16800)//预检间隔时间
                .allowedHeaders("*")//允许头部设置
                .allowCredentials(true);//是否发生cookie：是
    }

    /**
     * 功能描述:
     * 〈拦截器配置〉
     * @Author yls
     * @Date 2020/4/12 12:33
     * @param registry 拦截器注册管理
     * @return void
     **/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AppInterceptorl())
                .addPathPatterns("/**")
                .excludePathPatterns("/error");
    }
}
