package com.authority.manager.web.model.relation;

import com.authority.manager.web.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@ApiModel(description = "角色和菜单的关联表")
@Table(name = "sys_role_menu")
@org.hibernate.annotations.Table(appliesTo = "sys_role_menu",comment = "角色和菜单的关联表")
public class SysRoleMenuDO extends BaseModel {

    @ApiModelProperty("角色id")
    @Column(name = "role_id",columnDefinition = "int comment '角色id'")
    private int roleId;

    @ApiModelProperty("菜单id")
    @Column(name = "menu_id",columnDefinition = "int comment '菜单id'")
    private int menuId;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }


    @Override
    public String toString() {
        return "SysRoleMenu{" +
                ", roleId='" + roleId + '\'' +
                ", menuId='" + menuId + '\'' +
                '}';
    }
}