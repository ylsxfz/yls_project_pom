package com.authority.manager.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="sys_role")
public class SysRole extends BaseModel {

	@Column(name = "name")
    private String name;

	@Column(name = "remark")
    private String remark;

	@Column(name = "del_flag")
    private Byte delFlag;

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

	public Byte getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Byte delFlag) {
		this.delFlag = delFlag;
	}

	@Override
	public String toString() {
		return "SysRole{" +
				"name='" + name + '\'' +
				", remark='" + remark + '\'' +
				", delFlag=" + delFlag +
				'}';
	}
}