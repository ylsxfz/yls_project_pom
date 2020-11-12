package com.yls.ylscloudeurekaclientproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient  // 声明这是一个 Eureka 客户端
public class YlsCloudEurekaClientProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(YlsCloudEurekaClientProducerApplication.class, args);
    }

}
