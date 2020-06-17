package com.yls.hystrix_dashboard.controller;

import com.yls.hystrix_dashboard.controller.service.MyFeignProducterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yls
 * @Date 2020/4/7 13:56
 * @Description
 * @Version 1.0
 **/
@RestController
public class FeignHelloController {

    @Autowired
    private MyFeignProducterService myFeignProducterService;

    @RequestMapping("/feign/call")
    public String call(){
        //像调用本地接口一样
        return myFeignProducterService.hello();
    }
}
