package com.authority.manager.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@Entity
@Table(name="sys_menu")
public class SysMenu extends BaseModel {

	@Column(name = "parent_id")
    private String parentId;

	@Column(name = "name")
    private String name;

	@Column(name = "url")
    private String url;

	@Column(name = "perms")
    private String perms;

	@Column(name = "type")
    private Integer type;

	@Column(name = "icon")
    private String icon;

	@Column(name = "order_num")
    private Integer orderNum;

	@Column(name = "del_flag")
    private Byte delFlag;

    // 非数据库字段
	@Transient
	private String parentName;
    // 非数据库字段
	@Transient
	private Integer level;
    // 非数据库字段
	@Transient
	private List<SysMenu> children;

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
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

	public Byte getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Byte delFlag) {
		this.delFlag = delFlag;
	}

	public List<SysMenu> getChildren() {
		return children;
	}

	public void setChildren(List<SysMenu> children) {
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
				", delFlag=" + delFlag +
				", parentName='" + parentName + '\'' +
				", level=" + level +
				", children=" + children +
				'}';
	}
}