package com.yls.hystrix_dashboard.controller;

import com.yls.hystrix_dashboard.common.ServiceIdCommons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yls
 * @Date 2020/4/7 12:43
 * @Description
 * @Version 1.0
 **/
@RestController
public class ServiceController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * @Author yls
     * @Description 获取所有的服务 注意：注册中心的serviceId都是“-”，而不是下划线（_）
     * @Date 2020/4/7 12:49
     * @return java.lang.Object
     **/
    @RequestMapping("/services")
    public Object services(){
        return  discoveryClient.getInstances(ServiceIdCommons.PRODUCTER_SERVER_ID);
    }

    /**
     * @Author yls
     * @Description 从中选择一个服务
     * @Date 2020/4/7 12:49
     * @return java.lang.Object
     **/
    @RequestMapping("/discover")
    public Object discover(){
        return loadBalancerClient.choose(ServiceIdCommons.PRODUCTER_SERVER_ID).getUri().toString();
    }

}
