package com.authority.manager.functions.controller;

import com.authority.manager.functions.service.MyBatisSysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("user")
@Api(tags = "mybatis测试")
public class MyBatisSysUserController {

    @Value("${server.port}")
    String port;

    @Autowired
    private MyBatisSysUserService myBatisSysUserService;

    @ApiOperation(value = "根据xml查询用户")
    @PostMapping(value="/findAllByMyBatisXml")
    public Object findAllByMyBatisXml() {
        return myBatisSysUserService.findAllByMyBatisXml();
    }

    @ApiOperation(value = "根据注解查询用户")
    @PostMapping(value="/findAllByMyBatisAno")
    public Object findAllByMyBatisAno() {
        return myBatisSysUserService.findAllByMyBatisAno();
    }

    @ApiOperation(value = "保存session")
    @PostMapping(value="/saveSession")
    public Object saveSession(String name, HttpSession session) {
        session.setAttribute("name",name);
        return port;
    }

    @ApiOperation(value = "获取session")
    @PostMapping(value="/getSession")
    public Object getSession(HttpSession session) {
        return port + ":" + session.getAttribute("name").toString();
    }
}