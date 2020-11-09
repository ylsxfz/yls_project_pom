package com.authority.manager.functions.controller;

import com.authority.manager.functions.model.SysTestJpaUser;
import com.authority.manager.functions.service.JpaSysUserJpaService;
import com.yls.common.utils.StringFormatUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("component/jpa")
@Api(tags = "jpa测试")
public class JpaSysUserController {

    @Value("${server.port}")
    String port;

    @Autowired
    private JpaSysUserJpaService jpaSysUserJpaService;

    @ApiOperation(value = "添加用户")
    @PostMapping(value="/addUser")
    public Object addUser() {
        SysTestJpaUser sysTestJpaUser = new SysTestJpaUser();
        sysTestJpaUser.setUsername(StringFormatUtils.uuidUpperCase());
        return jpaSysUserJpaService.addUser(sysTestJpaUser);
    }

    @ApiOperation(value = "更新用户")
    @PostMapping(value="/updateUser")
    public Object updateUser() {
        SysTestJpaUser sysTestJpaUser = new SysTestJpaUser();
        sysTestJpaUser.setId(5);
        sysTestJpaUser.setUsername(StringFormatUtils.uuidUpperCase());
        sysTestJpaUser.setEmail("2689623000@qq.com");
        sysTestJpaUser.setAge(78);
        return jpaSysUserJpaService.updateUser(sysTestJpaUser);
    }


    @ApiOperation(value = "删除用户")
    @PostMapping(value="/deleteUser")
    public Object deleteUser() {
        jpaSysUserJpaService.deleteUser(1);
        return jpaSysUserJpaService.findAll();
    }

    @ApiOperation(value = "批量删除")
    @PostMapping(value="/deleteUsers")
    public Object deleteUsers() {
        jpaSysUserJpaService.deleteUsers();
        return "1";
    }

    @ApiOperation(value = "查询用户")
    @PostMapping(value="/listUsers")
    public Object listUsers() {
        return jpaSysUserJpaService.findAll();
    }

   }