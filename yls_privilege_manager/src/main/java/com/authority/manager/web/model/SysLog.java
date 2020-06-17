package com.authority.manager.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="sys_log")
public class SysLog extends BaseModel {

	@Column(name = "user_name")
    private String userName;

	@Column(name = "operation")
    private String operation;

	@Column(name = "method")
    private String method;

	@Column(name = "params")
    private String params;

	@Column(name = "time")
    private Long time;

	@Column(name = "ip")
    private String ip;

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

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public String toString() {
		return "SysLog{" +
				"userName='" + userName + '\'' +
				", operation='" + operation + '\'' +
				", method='" + method + '\'' +
				", params='" + params + '\'' +
				", time=" + time +
				", ip='" + ip + '\'' +
				'}';
	}
}