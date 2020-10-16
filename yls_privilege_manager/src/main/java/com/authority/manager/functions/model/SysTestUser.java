package com.authority.manager.functions.model;

import com.authority.manager.functions.model.mybatis.BaseMybatisTaskBO;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * @Auther: yls
 * @Date: 2020/09/13 09:54
 * @Description:
 * @Version 1.0
 */
@Entity
@Table(name = "sys_test_user")
public class SysTestUser extends BaseMybatisTaskBO {

    @ApiModelProperty("用户名")
    @Size(min = 2,max = 5,message = "{user.name.size}")
    @NotNull(message = "{user.address.notnull}")
    @Column(name = "username",columnDefinition = "varchar(32) comment '名称'")
    private String username;

    @ApiModelProperty("地址")
    @Column(name = "address",columnDefinition = "varchar(255) comment '地址'")
    private String address;

    @ApiModelProperty("性别")
    @Column(name = "gender",columnDefinition = "varchar(66) comment '性别'")
    private String gender;

    @ApiModelProperty("年龄")
    @DecimalMin(value = "1",message = "{user.age.size}")
    @DecimalMax(value = "200",message = "{user.age.size}")
    @Column(name = "age",columnDefinition = "varchar(32) comment '年龄'")
    private Integer age;

    @ApiModelProperty("邮箱")
    @Email(message = "{user.email.pattern}")
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
