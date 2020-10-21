package com.authority.manager.component.jsonfilter;

/**
 * @Auther: yls
 * @Date: 2020/10/21 23:34
 * @Description:
 * @Version 1.0
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

//三个注解貌似不加也可以
@Configuration
//@ComponentScan(basePackages = {"com.authority.manager.log.controller"}, useDefaultFilters = true)
public class JsonFilterConfig implements WebMvcConfigurer {// 生效
    @Bean
    public JsonReturnHandler jsonReturnHandler() {
        return new JsonReturnHandler();// 初始化json过滤器
    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
        returnValueHandlers.add(jsonReturnHandler());
    }

}