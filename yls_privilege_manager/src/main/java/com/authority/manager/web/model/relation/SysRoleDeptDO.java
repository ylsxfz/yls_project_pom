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

	@ApiModelProperty(value = "角色id",example = "1")
	@Column(name = "role_id",columnDefinition = "int comment '角色id'")
    private Integer roleId;

	@ApiModelProperty(value = "部门id",example = "1")
	@Column(name = "dept_id",columnDefinition = "int comment '部门id'")
    private Integer deptId;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
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