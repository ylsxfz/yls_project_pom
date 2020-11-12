package com.yls.ylscloudeurekaclientproducer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: yls
 * @Date: 2020/11/12 20:45
 * @Description:
 * @Version 1.0
 */
@RestController
@RequestMapping("/index")
public class IndexController {


    @GetMapping("/name")
    public Object callProvide(){
        return "你好，我是服务提供者！！！";
    }
}
