package com.authority.manager.web.model;

import com.authority.manager.web.model.base.BaseSysBO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

@Entity
@ApiModel(description = "菜单管理")
@Table(name="sys_menu")
@org.hibernate.annotations.Table(appliesTo = "sys_menu",comment = "菜单管理表")
public class SysMenuDO extends BaseSysBO implements Serializable {

	@ApiModelProperty("父级id")
	@Column(name = "parent_id",columnDefinition = "int comment '父级id'")
    private int parentId;

	@ApiModelProperty("名称")
	@Column(name = "name",columnDefinition = "varchar(32) comment '名称'")
    private String name;

	@ApiModelProperty("url地址")
	@Column(name = "url",columnDefinition = "varchar(64) comment 'url地址'")
    private String url;

	@ApiModelProperty("排列")
	@Column(name = "perms",columnDefinition = "varchar(64) comment '排列'")
    private String perms;

	@ApiModelProperty(value = "类型",example = "1")
	@Column(name = "type",columnDefinition = "int comment '类型'")
    private Integer type;

	@ApiModelProperty("图标")
	@Column(name = "icon",columnDefinition = "varchar(32) comment '图标'")
    private String icon;

	@ApiModelProperty("排序")
	@Column(name = "order_num",columnDefinition = "int comment '排序'")
    private Integer orderNum;

    // 非数据库字段
	@Transient
	@ApiModelProperty("父级名称")
	private String parentName;
    // 非数据库字段
	@Transient
	@ApiModelProperty(value = "等级",example = "1")
	private Integer level;
    // 非数据库字段
	@Transient
	@ApiModelProperty("下级菜单")
	private List<SysMenuDO> children;

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPerms() {
		return perms;
	}

	public void setPerms(String perms) {
		this.perms = perms;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}


	public List<SysMenuDO> getChildren() {
		return children;
	}

	public void setChildren(List<SysMenuDO> children) {
		this.children = children;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	@Override
	public String toString() {
		return "SysMenu{" +
				"parentId=" + parentId +
				", name='" + name + '\'' +
				", url='" + url + '\'' +
				", perms='" + perms + '\'' +
				", type=" + type +
				", icon='" + icon + '\'' +
				", orderNum=" + orderNum +
				", parentName='" + parentName + '\'' +
				", level=" + level +
				", children=" + children +
				'}';
	}
}