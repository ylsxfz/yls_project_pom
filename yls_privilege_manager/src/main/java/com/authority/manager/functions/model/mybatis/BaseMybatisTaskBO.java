package com.authority.manager.functions.model.mybatis;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author: yls
 * @Date: 2020/10/9 9:08
 * @Description: 利用jpa自动注入创建时间、创建人、更新时间、更新人
 * @Versionm 1.0
 */
@ApiModel(description = "任务父类")
@MappedSuperclass
public class BaseMybatisTaskBO implements Serializable {

    /**
     * 任务编号
     */
    @ApiModelProperty(value = "主键id:任务编号",example = "1")
    @Id
    //自动递增
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int comment 'id主键:任务编号'")
    @TableId(type = IdType.AUTO)
    private Integer id;


    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    @Column(name = "create_time", columnDefinition = "timestamp comment '创建时间'")
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    @Column(name = "create_by", columnDefinition = "varchar(32) comment '创建人'")
    @TableField(value = "create_by",fill = FieldFill.INSERT)
    private String createBy;


    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    @Column(name = "update_time", columnDefinition = "timestamp comment '更新时间'")
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


    /**
     * 修改人
     */
    @ApiModelProperty("修改人")
    @Column(name = "update_by", columnDefinition = "varchar(32) comment '修改人'")
    @TableField(value = "update_by",fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

    /**
     * 是否删除
     */
    @ApiModelProperty(value = "逻辑删除",example = "1")
    @Column(name = "is_deleted",columnDefinition = "tinyint comment '删除标记=> 1：已删除，0：未删除'")
    // 逻辑删除
    @TableLogic
    @TableField(value = "is_deleted",fill = FieldFill.INSERT)
    private Integer deleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }


    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "BaseJpaTaskBO{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", createBy='" + createBy + '\'' +
                ", updateTime=" + updateTime +
                ", updateBy='" + updateBy + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}
