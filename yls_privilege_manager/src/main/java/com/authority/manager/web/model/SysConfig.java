package com.authority.manager.web.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@ApiModel(description = "系统配置")
@Entity
@Table(name="sys_config")
public class SysConfig extends BaseModel {

	@ApiModelProperty(value = "值")
	@Column(name = "value")
    private String value;

	@ApiModelProperty(value = "标签")
	@Column(name = "label")
    private String label;

	@ApiModelProperty(value = "类型")
	@Column(name = "type")
    private String type;

	@ApiModelProperty(value = "描述")
	@Column(name = "description")
    private String description;

	@ApiModelProperty(value = "排序")
	@Column(name = "sort")
    private Long sort;

	@ApiModelProperty(value = "备注")
	@Column(name = "remarks")
    private String remarks;

	@ApiModelProperty(value = "删除标记")
	@Column(name = "del_flag")
    private Byte delFlag;


	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getSort() {
		return sort;
	}

	public void setSort(Long sort) {
		this.sort = sort;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Byte getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Byte delFlag) {
		this.delFlag = delFlag;
	}

	@Override
	public String toString() {
		return "SysConfig{" +
				"value='" + value + '\'' +
				", label='" + label + '\'' +
				", type='" + type + '\'' +
				", description='" + description + '\'' +
				", sort=" + sort +
				", remarks='" + remarks + '\'' +
				", delFlag=" + delFlag +
				'}';
	}
}