package com.yls.producter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yls
 * @Date 2020/4/7 12:21
 * @Description 服务消费测试
 * @Version 1.0
 **/
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello yls_producter_one";
    }
}
