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
public class SysDept extends BaseModel {

	@ApiModelProperty(value = "名称")
	@Column(name = "name")
    private String name;

	@ApiModelProperty(value = "父级id")
	@Column(name = "parent_id")
    private String parentId;

	@ApiModelProperty(value = "排序值")
	@Column(name = "order_num")
    private Integer orderNum;

	@ApiModelProperty(value = "删除标记")
	@Column(name = "del_flag")
    private Byte delFlag;

    // 非数据库字段
	@Transient
	private List<SysDept> children;
    // 非数据库字段
	@Transient
	private String parentName;
    // 非数据库字段
	@Transient
	private Integer level;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
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
				", delFlag=" + delFlag +
				", children=" + children +
				", parentName='" + parentName + '\'' +
				", level=" + level +
				'}';
	}
}