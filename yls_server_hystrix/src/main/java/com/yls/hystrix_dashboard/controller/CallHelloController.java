package com.yls.hystrix_dashboard.controller;

import com.yls.hystrix_dashboard.common.ServiceIdCommons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author yls
 * @Date 2020/4/7 13:10
 * @Description 测试查找服务并调用服务
 * @Version 1.0
 **/
@RestController
public class CallHelloController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/call")
    public String call(){
        //1、查找服务，用LoadBalancer查询服务，LoadBalancerClient是负载均衡器
        ServiceInstance serviceInstance = loadBalancerClient.choose(ServiceIdCommons.PRODUCTER_SERVER_ID);
        System.err.println("服务地址："+serviceInstance.getUri());
        System.err.println("服务名称："+serviceInstance.getServiceId());

        //2、调用服务，通过RestTemplate远程调用
        String result = new RestTemplate().getForObject(serviceInstance.getUri().toString() + "/hello", String.class);
        System.out.println("执行结果："+result);
        return result;
    }
}
