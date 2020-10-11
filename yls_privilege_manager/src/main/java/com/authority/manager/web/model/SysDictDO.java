package com.authority.manager.web.model;

import com.authority.manager.web.model.base.BaseSysBO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="sys_dict")
@ApiModel(description = "字典管理")
@org.hibernate.annotations.Table(appliesTo = "sys_dict",comment = "字典管理表")
public class SysDictDO extends BaseSysBO {

	@ApiModelProperty("值")
	@Column(name = "value",columnDefinition = "varchar(32) comment '值'")
    private String value;

	@ApiModelProperty("标签")
	@Column(name = "label",columnDefinition = "varchar(32) comment '标签'")
    private String label;

	@ApiModelProperty("类型")
	@Column(name = "type",columnDefinition = "varchar(32) comment '类型'")
    private String type;

	@ApiModelProperty("描述")
	@Column(name = "description",columnDefinition = "varchar(255) comment '描述'")
    private String description;

	@ApiModelProperty("排序")
	@Column(name = "sort",columnDefinition = "int comment '排序'")
    private int sort;

	@ApiModelProperty("备注")
	@Column(name = "remarks",columnDefinition = "varchar(255) comment '备注'")
    private String remarks;



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

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	@Override
	public String toString() {
		return "SysDict{" +
				"value='" + value + '\'' +
				", label='" + label + '\'' +
				", type='" + type + '\'' +
				", description='" + description + '\'' +
				", sort=" + sort +
				", remarks='" + remarks + '\'' +
				'}';
	}
}