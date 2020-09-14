package com.authority.manager.web.model.relation;

import com.authority.manager.web.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@ApiModel(description = "用户和角色关联表")
@Table(name="sys_user_role")
@org.hibernate.annotations.Table(appliesTo = "sys_user_role",comment = "用户和角色关联表")
public class SysUserRoleDO extends BaseModel {

	@ApiModelProperty("用户id")
	@Column(name = "user_id",columnDefinition = "int comment '用户id'")
    private int userId;

	@ApiModelProperty("角色id")
	@Column(name = "role_id",columnDefinition = "int comment '角色id'")
    private int roleId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "SysUserRole{" +
				", userId='" + userId + '\'' +
				", roleId='" + roleId + '\'' +
				'}';
	}
}