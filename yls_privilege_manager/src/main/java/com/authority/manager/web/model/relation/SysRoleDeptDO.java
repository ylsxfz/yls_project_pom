package com.authority.manager.web.model.relation;

import com.authority.manager.web.model.base.BaseSysBO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@ApiModel(description = "角色和部门的关联表")
@Table(name="sys_role_dept")
@org.hibernate.annotations.Table(appliesTo = "sys_role_dept",comment = "角色和部门的关联表")
public class SysRoleDeptDO extends BaseSysBO implements Serializable {

	@ApiModelProperty("角色id")
	@Column(name = "role_id",columnDefinition = "int comment '角色id'")
    private int roleId;

	@ApiModelProperty("部门id")
	@Column(name = "dept_id",columnDefinition = "int comment '部门id'")
    private int deptId;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}


	@Override
	public String toString() {
		return "SysRoleDept{" +
				", roleId='" + roleId + '\'' +
				", deptId='" + deptId + '\'' +
				'}';
	}
}