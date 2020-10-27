package com.authority.manager.log.model;

import com.authority.manager.functions.model.jpa.BaseJpaTaskBO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@ApiModel(description = "系统日志")
@Table(name="system_log")
@org.hibernate.annotations.Table(appliesTo = "system_log",comment = "系统日志表")
public class SystemLogDO extends BaseJpaTaskBO implements Serializable {

	@ApiModelProperty(value = "用户名")
	@Column(name = "user_name",columnDefinition = "varchar(32) comment '用户名'")
    private String userName;

	@ApiModelProperty("操作")
	@Column(name = "operation",columnDefinition = "varchar(64) comment '操作'")
    private String operation;

	@ApiModelProperty("方法名")
	@Column(name = "method",columnDefinition = "text comment '方法名'")
    private String method;

	@ApiModelProperty("参数")
	@Column(name = "params",columnDefinition = "text comment '参数'")
    private String params;

	@ApiModelProperty("ip地址")
	@Column(name = "ip",columnDefinition = "varchar(32) comment 'ip地址'")
    private String ip;

	@ApiModelProperty("请求URI")
	@Column(name = "request_uri",columnDefinition = "varchar(255) comment '请求URI'")
	private String requestUri;

	@ApiModelProperty("请求类型")
	@Column(name = "request_method",columnDefinition = "varchar(255) comment '请求类型'")
	private String requestMethod;

	@ApiModelProperty("异常描述")
	@Column(name = "exception_log",columnDefinition = "text comment '异常描述'")
	private String exceptionLog;           // 异常描述

	@ApiModelProperty("日志类型")
	@Column(name = "type",columnDefinition = "varchar(255) comment '日志类型'")
	private String type;


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getRequestUri() {
		return requestUri;
	}

	public void setRequestUri(String requestUri) {
		this.requestUri = requestUri;
	}

	public String getRequestMethod() {
		return requestMethod;
	}

	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}

	public String getExceptionLog() {
		return exceptionLog;
	}

	public void setExceptionLog(String exceptionLog) {
		this.exceptionLog = exceptionLog;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "SystemLogDO{" +
				"userName='" + userName + '\'' +
				", operation='" + operation + '\'' +
				", method='" + method + '\'' +
				", params='" + params + '\'' +
				", ip='" + ip + '\'' +
				", requestUri='" + requestUri + '\'' +
				", requestMethod='" + requestMethod + '\'' +
				", exceptionLog='" + exceptionLog + '\'' +
				", type='" + type + '\'' +
				'}';
	}
}