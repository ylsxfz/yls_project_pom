package com.authority.manager.webservice.serice.impl;

import com.authority.manager.webservice.serice.InitWebService;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

/**
 * @Author yls
 * @Description webService具体实现
 * @Date 2020/3/30 21:12
 **/
@WebService(name="InitWebService",//暴露服务名称
		targetNamespace="http://service.webservice.boot.spring.com/",//命名空间，一般是接口的倒序
		endpointInterface="com.authority.manager.webservice.serice.InitWebService"
)
@Component
public class InitWebServiceImpl implements InitWebService {

	@Override
	public String sayHello(String name) {
		return "hello,"+name;
	}

}
