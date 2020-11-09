package com.authority.manager.web.model.relation;

import com.authority.manager.web.model.base.BaseSysBO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@ApiModel(description = "用户和角色关联表")
@Table(name="sys_user_role")
@org.hibernate.annotations.Table(appliesTo = "sys_user_role",comment = "用户和角色关联表")
public class SysUserRoleDO extends BaseSysBO implements Serializable {

	@ApiModelProperty(value = "用户id",example = "1")
	@Column(name = "user_id",columnDefinition = "int comment '用户id'")
    private Integer userId;

	@ApiModelProperty(value = "角色id",example = "1")
	@Column(name = "role_id",columnDefinition = "int comment '角色id'")
    private Integer roleId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
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