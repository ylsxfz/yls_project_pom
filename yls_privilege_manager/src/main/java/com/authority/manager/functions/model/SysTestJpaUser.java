package com.authority.manager.functions.model;

import com.authority.manager.functions.model.jpa.BaseJpaTaskBO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLDeleteAll;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @Auther: yls
 * @Date: 2020/09/13 09:54
 * @Description:
 * @Version 1.0
 */
@Entity
@Table(name = "sys_test_jpa_user")
@SQLDelete(sql = "update sys_test_jpa_user set is_deleted = 1 where id = ?")
@SQLDeleteAll(sql = "update sys_test_jpa_user set is_deleted = 1 where id in (?)")
@Where(clause = "is_deleted = 0")
@ApiModel(description = "测试jpa用户实体类")
public class SysTestJpaUser extends BaseJpaTaskBO implements Serializable {

    @ApiModelProperty("用户名")
    @Size(min = 2,max = 100,message = "{user.name.size}")
    @Column(name = "username",columnDefinition = "varchar(32) comment '名称'")
    private String username;

    @ApiModelProperty("地址")
    // @NotNull(message = "{user.address.notnull}")
    @Column(name = "address",columnDefinition = "varchar(255) comment '地址'")
    private String address;

    @ApiModelProperty("性别")
    @Column(name = "gender",columnDefinition = "varchar(66) comment '性别'")
    private String gender;

    @ApiModelProperty(value = "年龄",example = "1")
    @DecimalMin(value = "1",message = "{user.age.size}")
    @DecimalMax(value = "200",message = "{user.age.size}")
    @Column(name = "age",columnDefinition = "varchar(32) comment '年龄'")
    private Integer age;

    @ApiModelProperty("邮箱")
    // @Email(message = "{user.email.pattern}")
    @Column(name = "email",columnDefinition = "varchar(64) comment '邮箱'")
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
