package com.authority.manager.web.model.log;

import com.authority.manager.component.security.utils.SecurityUtils;
import com.yls.common.utils.DateUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.persistence.*;

@Entity
@ApiModel(description = "系统登录日志")
@Table(name="sys_login_log")
@org.hibernate.annotations.Table(appliesTo = "sys_login_log",comment = "系统登录日志表")
public class SysLoginLog{

	@ApiModelProperty("主键id")
	@Id
	//自动递增
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",columnDefinition = "int comment '唯一主键id'")
	private int id;

	@ApiModelProperty("用户名")
	@Column(name = "user_name",columnDefinition = "varchar(32) comment '用户名'")
    private String userName;

	@ApiModelProperty("状态")
	@Column(name = "status",columnDefinition = "varchar(32) comment '状态'")
    private String status;

	@ApiModelProperty("ip地址")
	@Column(name = "ip",columnDefinition = "varchar(32) comment 'ip地址'")
    private String ip;

	@ApiModelProperty("登录时间")
	@Column(name = "create_time",columnDefinition = "varchar(32) comment '登录时间'")
	private String createTime;

	@ApiModelProperty("备注")
	@Column(name = "remark",columnDefinition = "varchar(255) comment '备注'")
	private String remark;

	public SysLoginLog(){

	}

	public SysLoginLog(String status) {
		this.status = status;
		//用户名
		this.userName = SecurityUtils.getUsername();
		//获取当前登录信息
		if (SecurityUtils.getUsername()!=null){
			this.ip =((WebAuthenticationDetails) SecurityUtils.getAuthentication().getDetails())
					.getRemoteAddress();
		}
		//创建时间
		this.createTime= DateUtils.getNowDateTime();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "SysLoginLog{" +
				"id=" + id +
				", userName='" + userName + '\'' +
				", status='" + status + '\'' +
				", ip='" + ip + '\'' +
				", createTime='" + createTime + '\'' +
				", remark='" + remark + '\'' +
				'}';
	}
}