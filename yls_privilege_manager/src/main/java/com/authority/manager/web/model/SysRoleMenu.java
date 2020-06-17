package com.authority.manager.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="sys_role_menu")
public class SysRoleMenu extends BaseModel {

	@Column(name = "role_id")
    private String roleId;

	@Column(name = "menu_id")
    private String menuId;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	@Override
	public String toString() {
		return "SysRoleMenu{" +
				"roleId=" + roleId +
				", menuId=" + menuId +
				'}';
	}
}