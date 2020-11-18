package com.authority.manager;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * 系统程序的主函数：主入口
 */
@SpringBootApplication // 等同于 @EnableAutoConfiguration @SpringBootConfiguration @ComponentScan
//@EnableDiscoveryClient // 注册服务
@EnableAsync
@EnableSwagger2 // swagger2文档接口
@ServletComponentScan // 自动扫描
@EnableBatchProcessing // 开启批处理的支持
@EnableJpaAuditing // 自动更新创建时间和上一次更新时间,创建人等
@ImportResource(locations = {"classpath:spring-mvc.xml"})//引入自定义的配置文件
public class ManagerApplication {

    /**
     * 功能描述:
     * 〈系统的主函数：可以携带参数〉
     * @author : yls
     * @date : 2020/07/12 10:59
     * @param args 系统执行时添加的参数数组
     * @return : void
     */
    public static void main(String[] args) {
        SpringApplication.run(ManagerApplication.class, args);
    }

}
