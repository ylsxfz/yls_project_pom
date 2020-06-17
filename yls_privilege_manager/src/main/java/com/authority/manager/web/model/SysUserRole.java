package com.authority.manager.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="sys_user_role")
public class SysUserRole extends BaseModel {
	@Column(name = "user_id")
    private String userId;

	@Column(name = "role_id")
    private String roleId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "SysUserRole{" +
				"userId=" + userId +
				", roleId=" + roleId +
				'}';
	}
}