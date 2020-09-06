package com.authority.manager.web.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@ApiModel(description = "部门")
@Entity
@Table(name="sys_dept")
@org.hibernate.annotations.Table(appliesTo = "sys_dept",comment = "部门表")
public class SysDept extends BaseModel {

	@ApiModelProperty("名称")
	@Column(name = "name",columnDefinition = "varchar(32) comment '名称'")
    private String name;

	@ApiModelProperty("父级id")
	@Column(name = "parent_id",columnDefinition = "int comment '父级id'")
    private int parentId;

	@ApiModelProperty("排序值")
	@Column(name = "order_num",columnDefinition = "int comment '排序值'")
    private Integer orderNum;

    // 非数据库字段
	@Transient
	@ApiModelProperty("下级部门")
	private List<SysDept> children;
    // 非数据库字段
	@Transient
	@ApiModelProperty("父级名称")
	private String parentName;
    // 非数据库字段
	@Transient
	@ApiModelProperty("等级")
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
	public List<SysDept> getChildren() {
		return children;
	}
	public void setChildren(List<SysDept> children) {
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