package com.authority.manager.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @Author yls
 * @Date 2020/4/6 8:55
 * @Description 生成验证码
 * @Version 1.0
 **/
@Configuration
public class KaptchaConfig {
    /**
     * @Author yls
     * @Description 生成验证码的一些简单配置
     * @Date 2020/4/6 9:02
     * @return com.google.code.kaptcha.impl.DefaultKaptcha
     **/
    @Bean
    public DefaultKaptcha producer(){
        Properties properties = new Properties();
        properties.put("kaptcha.border","no");
        properties.put("kaptcha.textproducer.font.color","black");
        properties.put("kaptcha.textproducer.char.space","5");
        Config config = new Config(properties);
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}
