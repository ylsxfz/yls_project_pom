package com.authority.manager.web.model;

import com.authority.manager.web.model.relation.SysUserRoleDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Entity
@ApiModel(description = "用户")
@Table(name="sys_user")
@org.hibernate.annotations.Table(appliesTo = "sys_user",comment = "用户表")
public class SysUserDO extends BaseModel {

	@ApiModelProperty("名称")
	@Column(name = "name",columnDefinition = "varchar(32) comment '名称'")
    private String name;

	@ApiModelProperty("昵称")
	@Column(name = "nick_name",columnDefinition = "varchar(32) comment '昵称'")
    private String nickName;

	@ApiModelProperty("")
	@Column(name = "avatar",columnDefinition = "varchar(255) comment ''")
    private String avatar;

	@ApiModelProperty("密码")
	@Column(name = "password",columnDefinition = "varchar(32) comment '密码'")
    private String password;

	@ApiModelProperty("")
	@Column(name = "salt",columnDefinition = "varchar(255) comment ''")
    private String salt;

	@ApiModelProperty("邮箱")
	@Column(name = "email",columnDefinition = "varchar(64) comment '邮箱'")
    private String email;

	@ApiModelProperty("电话")
	@Column(name = "mobile",columnDefinition = "varchar(32) comment '电话'")
    private String mobile;

	@ApiModelProperty("状态")
	@Column(name = "status",columnDefinition = "tinyint comment '状态'")
    private Byte status;

	@ApiModelProperty("部门id")
	@Column(name = "dept_id",columnDefinition = "int comment '部门id'")
    private int deptId;

    // 非数据库字段
	@Transient
	@ApiModelProperty("部门名称")
	private String deptName;

    // 非数据库字段
	@Transient
	@ApiModelProperty("角色名称")
	private String roleNames;

    // 非数据库字段
	@Transient
	@ApiModelProperty("用户权限集合")
	private List<SysUserRoleDO> userRoles = new ArrayList<>();

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

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
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
	public List<SysUserRoleDO> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(List<SysUserRoleDO> userRoles) {
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
				", deptName='" + deptName + '\'' +
				", roleNames='" + roleNames + '\'' +
				", userRoles=" + userRoles +
				'}';
	}
}