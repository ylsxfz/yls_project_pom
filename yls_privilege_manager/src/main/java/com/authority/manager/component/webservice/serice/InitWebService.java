package com.authority.manager.component.webservice.serice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @Author yls
 * @Description webservice具体实现
 * @Date 2020/3/30 21:12
 **/
@WebService(name="InitWebService",//暴露服务名称
		targetNamespace="http://service.webservice.manager.authority.com/"//命名空间，一般是接口的倒序
		)
public interface InitWebService {
	@WebMethod
	public String sayHello(@WebParam(name = "userName") String name);
}
