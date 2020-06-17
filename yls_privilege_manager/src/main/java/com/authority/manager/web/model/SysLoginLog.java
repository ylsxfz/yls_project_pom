package com.authority.manager.web.model;

import com.authority.manager.security.utils.SecurityUtils;
import com.yls.common.utils.DateUtils;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.persistence.*;

@Entity
@Table(name="sys_login_log")
public class SysLoginLog{

	@Id
	@GenericGenerator(name = "uId", strategy = "uuid.hex")
	@GeneratedValue(generator = "uId")
	@Column(name = "id", length = 32)
	private String id;


	@Column(name = "user_name")
    private String userName;

	@Column(name = "status")
    private String status;

	@Column(name = "ip")
    private String ip;

	@Column(name = "create_time")
	private String createTime;

	@Column(name = "remark")
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
				"userName='" + userName + '\'' +
				", status='" + status + '\'' +
				", ip='" + ip + '\'' +
				", createTime='" + createTime + '\'' +
				", remark='" + remark + '\'' +
				'}';
	}
}