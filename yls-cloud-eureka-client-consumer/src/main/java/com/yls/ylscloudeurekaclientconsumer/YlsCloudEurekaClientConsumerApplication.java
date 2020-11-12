package com.yls.ylscloudeurekaclientconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient // 声明这是一个客户端
public class YlsCloudEurekaClientConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(YlsCloudEurekaClientConsumerApplication.class, args);
    }

}
