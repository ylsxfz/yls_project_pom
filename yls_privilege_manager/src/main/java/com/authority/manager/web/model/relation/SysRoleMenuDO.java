package com.authority.manager.web.model.relation;

import com.authority.manager.web.model.base.BaseSysBO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@ApiModel(description = "角色和菜单的关联表")
@Table(name = "sys_role_menu")
@org.hibernate.annotations.Table(appliesTo = "sys_role_menu",comment = "角色和菜单的关联表")
public class SysRoleMenuDO extends BaseSysBO implements Serializable {

    @ApiModelProperty(value = "角色id",example = "1")
    @Column(name = "role_id",columnDefinition = "int comment '角色id'")
    private Integer roleId;

    @ApiModelProperty(value = "菜单id",example = "1")
    @Column(name = "menu_id",columnDefinition = "int comment '菜单id'")
    private Integer menuId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
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