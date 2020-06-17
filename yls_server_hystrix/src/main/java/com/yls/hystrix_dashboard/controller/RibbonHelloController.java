package com.yls.hystrix_dashboard.controller;

import com.yls.hystrix_dashboard.common.ServiceIdCommons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author yls
 * @Date 2020/4/7 13:23
 * @Description 测试
 * @Version 1.0
 **/
@RestController
public class RibbonHelloController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/ribbon/call")
    public String call(){
        //调用服务
        String result = restTemplate.getForObject("http://" + ServiceIdCommons.PRODUCTER_SERVER_ID + "/hello", String.class);
        return result;
    }
}
