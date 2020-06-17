package com.authority.manager.web.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * @Author yls
 * @Description 基础模型
 * @Date 2020/4/5 9:46
 **/
@ApiModel(description = "基础模型，公共的字段属性")
@MappedSuperclass
public class BaseModel {

	@ApiModelProperty(value = "主键id")
	@Id
	@GenericGenerator(name = "uId", strategy = "uuid.hex")
	@GeneratedValue(generator = "uId")
	@Column(name = "id", length = 32)
	private String id;

	@ApiModelProperty(value = "创建人")
	@Column(name = "create_by")
    private String createBy;

	@ApiModelProperty(value = "创建时间")
	@Column(name = "create_time")
    private Date createTime;

	@ApiModelProperty(value = "上一次更新者")
	@Column(name = "last_update_by")
    private String lastUpdateBy;

	@ApiModelProperty(value = "上一次更新时间")
	@Column(name = "last_update_time")
    private Date lastUpdateTime;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

}
