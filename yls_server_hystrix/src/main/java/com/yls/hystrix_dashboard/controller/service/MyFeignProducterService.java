package com.yls.hystrix_dashboard.controller.service;

import com.yls.hystrix_dashboard.common.ServiceIdCommons;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author yls
 * @Date 2020/4/7 13:54
 * @Description fallback测试熔断器
 * @Version 1.0
 **/
@FeignClient(name = ServiceIdCommons.PRODUCTER_SERVER_ID,fallback = MyProducerHytrix.class)
public interface MyFeignProducterService {

    @RequestMapping("/hello")
    public String hello();
}
