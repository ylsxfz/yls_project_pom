package com.authority.manager.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="sys_user")
public class SysUser extends BaseModel {

	@Column(name = "name")
    private String name;

	@Column(name = "nick_name")
    private String nickName;

	@Column(name = "avatar")
    private String avatar;

	@Column(name = "password")
    private String password;

	@Column(name = "salt")
    private String salt;

	@Column(name = "email")
    private String email;

	@Column(name = "mobile")
    private String mobile;

	@Column(name = "status")
    private Byte status;

	@Column(name = "dept_id")
    private String deptId;

	@Column(name = "del_flag")
    private Byte delFlag;
    
    // 非数据库字段
	@Transient
	private String deptName;
    // 非数据库字段
	@Transient
	private String roleNames;
    // 非数据库字段
	@Transient
	private List<SysUserRole> userRoles = new ArrayList<>();

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Byte getStatus() {
		return status;
	}
	public void setStatus(Byte status) {
		this.status = status;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public Byte getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(Byte delFlag) {
		this.delFlag = delFlag;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getRoleNames() {
		return roleNames;
	}
	public void setRoleNames(String roleNames) {
		this.roleNames = roleNames;
	}
	public List<SysUserRole> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(List<SysUserRole> userRoles) {
		this.userRoles = userRoles;
	}

	@Override
	public String toString() {
		return "SysUser{" +
				"name='" + name + '\'' +
				", nickName='" + nickName + '\'' +
				", avatar='" + avatar + '\'' +
				", password='" + password + '\'' +
				", salt='" + salt + '\'' +
				", email='" + email + '\'' +
				", mobile='" + mobile + '\'' +
				", status=" + status +
				", deptId=" + deptId +
				", delFlag=" + delFlag +
				", deptName='" + deptName + '\'' +
				", roleNames='" + roleNames + '\'' +
				", userRoles=" + userRoles +
				'}';
	}
}