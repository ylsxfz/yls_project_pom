package com.authority.manager.web.model.base;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author yls
 * @Description 基础模型
 * @Date 2020/4/5 9:46
 **/
@ApiModel(description = "基础模型，公共的字段属性")
@MappedSuperclass
public class BaseSysBO implements Serializable {

	@ApiModelProperty("主键id")
	@Id
	//@GenericGenerator(name = "uId", strategy = "uuid.hex")
	//@GeneratedValue(generator = "uId")
	//自动递增
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "id",columnDefinition = "int comment 'id主键'")
	private int id;

	@ApiModelProperty("创建人")
	@Column(name = "create_by",columnDefinition = "varchar(32) comment '创建人'")
	//该注解表示返回信息不包括该字段
	@JsonIgnore
    private String createBy;

	@ApiModelProperty("创建时间")
	@Column(name = "create_time",columnDefinition = "datetime comment '创建人'")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

	@ApiModelProperty("上一次更新者")
	@Column(name = "last_update_by",columnDefinition = "varchar(32) comment '上一次更新者'")
    private String lastUpdateBy;

	@ApiModelProperty("上一次更新时间")
	@Column(name = "last_update_time",columnDefinition = "datetime comment '上一次更新时间'")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdateTime;

	@ApiModelProperty("删除标记，1：未删除，0：已删除")
	@Column(name = "del_flag",columnDefinition = "tinyint comment '删除标记，1：未删除，0：已删除'")
	private Byte delFlag;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Byte getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Byte delFlag) {
		this.delFlag = delFlag;
	}
}
