package com.authority.manager.web.model.log;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@ApiModel(description = "系统日志")
@Table(name="sys_log")
@org.hibernate.annotations.Table(appliesTo = "sys_log",comment = "系统日志表")
public class SysLogDO implements Serializable {

	@ApiModelProperty(value = "主键id",example = "1")
	@Id
	//自动递增
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",columnDefinition = "int comment '唯一主键id'")
	private int id;

	@ApiModelProperty(value = "用户名")
	@Column(name = "user_name",columnDefinition = "varchar(32) comment '用户名'")
    private String userName;

	@ApiModelProperty("操作")
	@Column(name = "operation",columnDefinition = "varchar(64) comment '操作'")
    private String operation;

	@ApiModelProperty("方法名")
	@Column(name = "method",columnDefinition = "varchar(64) comment '方法名'")
    private String method;

	@ApiModelProperty("参数")
	@Column(name = "params",columnDefinition = "varchar(255) comment '参数'")
    private String params;

	@ApiModelProperty("时间")
	@Column(name = "time",columnDefinition = "bigint comment '时间'")
    private Long time;

	@ApiModelProperty("ip地址")
	@Column(name = "ip",columnDefinition = "varchar(32) comment 'ip地址'")
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "SysLog{" +
				"id=" + id +
				", userName='" + userName + '\'' +
				", operation='" + operation + '\'' +
				", method='" + method + '\'' +
				", params='" + params + '\'' +
				", time=" + time +
				", ip='" + ip + '\'' +
				'}';
	}
}