package com.authority.manager.web.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@ApiModel(description = "系统权限")
@Table(name="sys_role")
@org.hibernate.annotations.Table(appliesTo = "sys_role",comment = "系统权限表")
public class SysRole extends BaseModel {

	@ApiModelProperty("名称")
	@Column(name = "name",columnDefinition = "varchar(32) comment '名称'")
    private String name;

	@ApiModelProperty("备注")
	@Column(name = "remark",columnDefinition = "varchar(255) comment '备注'")
    private String remark;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "SysRole{" +
				"name='" + name + '\'' +
				", remark='" + remark + '\'' +
				'}';
	}
}