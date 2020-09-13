package com.authority.manager.functions.model;

import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * @Auther: yls
 * @Date: 2020/09/13 09:54
 * @Description:
 * @Version 1.0
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 2,max = 5,message = "{user.name.size}")
    @Column(name = "username")
    private String username;

    @NotNull(message = "{user.address.notnull}")
    @Column(name = "address")
    private String address;

    @Column(name = "gender")
    private String gender;

    @DecimalMin(value = "1",message = "{user.age.size}")
    @DecimalMax(value = "200",message = "{user.age.size}")
    @Column(name = "age")
    private Integer age;

    @Email(message = "{user.email.pattern}")
    @NotNull(message = "{user.email.notnull}")
    @Column(name = "email")
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
                "id=" + id +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
