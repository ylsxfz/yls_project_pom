package com.authority.manager.component.webservice.conf;

import com.authority.manager.component.webservice.serice.InitWebService;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * @Author yls
 * @Description webService配置
 * @Date 2020/3/30 21:12
 **/
@Configuration
public class WebServiceConf extends SpringBootServletInitializer{
	@Autowired
	private Bus bus;
	
	@Autowired
	private InitWebService initWebService;
	
	@Bean
	public Endpoint endpoint() {
		//测试地址：http://localhost:8443/services/YLSInitWebService?wsdl
		EndpointImpl endpoint = new EndpointImpl(bus,initWebService);
		endpoint.publish("/YLSInitWebService");
		return endpoint;
	}
}
