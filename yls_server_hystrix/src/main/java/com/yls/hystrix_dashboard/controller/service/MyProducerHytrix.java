package com.yls.hystrix_dashboard.controller.service;

import org.springframework.stereotype.Component;

/**
 * @Author yls
 * @Date 2020/4/7 14:38
 * @Description 测试熔断器，回调函数
 * @Version 1.0
 **/
@Component
public class MyProducerHytrix implements MyFeignProducterService {

    @Override
    public String hello() {
        return "sorry,hello service call failed.";
    }
}
