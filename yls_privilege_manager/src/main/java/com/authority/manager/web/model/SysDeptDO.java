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

@ApiModel(description = "部门")
@Entity
@Table(name="sys_dept")
@org.hibernate.annotations.Table(appliesTo = "sys_dept",comment = "部门表")
public class SysDeptDO extends BaseSysBO implements Serializable {

	@ApiModelProperty("名称")
	@Column(name = "name",columnDefinition = "varchar(32) comment '名称'")
    private String name;

	@ApiModelProperty("父级id")
	@Column(name = "parent_id",columnDefinition = "int comment '父级id'")
    private int parentId;

	@ApiModelProperty(value = "排序值",example = "1")
	@Column(name = "order_num",columnDefinition = "int comment '排序值'")
    private Integer orderNum;

    // 非数据库字段
	@Transient
	@ApiModelProperty("下级部门")
	private List<SysDeptDO> children;
    // 非数据库字段
	@Transient
	@ApiModelProperty("父级名称")
	private String parentName;
    // 非数据库字段
	@Transient
	@ApiModelProperty(value = "等级",example = "1")
	private Integer level;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public Integer getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	public List<SysDeptDO> getChildren() {
		return children;
	}
	public void setChildren(List<SysDeptDO> children) {
		this.children = children;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "SysDept{" +
				"name='" + name + '\'' +
				", parentId=" + parentId +
				", orderNum=" + orderNum +
				", children=" + children +
				", parentName='" + parentName + '\'' +
				", level=" + level +
				'}';
	}
}