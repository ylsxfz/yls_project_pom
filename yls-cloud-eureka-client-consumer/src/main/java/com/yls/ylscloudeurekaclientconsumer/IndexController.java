package com.yls.ylscloudeurekaclientconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: yls
 * @Date: 2020/11/12 20:45
 * @Description:
 * @Version 1.0
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 功能描述:
     * 〈
     * 直接访问提供者，绕开了eureka服务中心
     * 注意：由于 @LoadBalanced 注解， 这里不能用127.0.0.1
     * 〉
     *
     * @param
     * @return : java.lang.String
     * @author : yls
     * @date : 2020/11/12 21:03
     */
    @GetMapping("/callProducer")
    public String callProducer() {
        return restTemplate.getForObject(
                "http://YLS-CLOUD-EUREKA-CLIENT-PRODUCER:8771/index/name",
                String.class
        );
    }


    @GetMapping("/callProvider")
    public String callProvider() {
        return restTemplate.getForObject(
                "http://YLS-CLOUD-EUREKA-CLIENT-PRODUCER/index/name",
                String.class
        );
    }

}
