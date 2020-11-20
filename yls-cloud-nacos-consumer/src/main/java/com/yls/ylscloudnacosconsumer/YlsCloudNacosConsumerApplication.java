package com.yls.ylscloudnacosconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class YlsCloudNacosConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(YlsCloudNacosConsumerApplication.class, args);
    }

}
