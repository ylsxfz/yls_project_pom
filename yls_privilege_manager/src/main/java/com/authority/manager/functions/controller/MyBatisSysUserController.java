package com.authority.manager.functions.controller;

import com.authority.manager.functions.service.MyBatisSysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("user")
public class MyBatisSysUserController {

    @Value("${server.port}")
    String port;

    @Autowired
    private MyBatisSysUserService myBatisSysUserService;
    
    @PostMapping(value="/findAllByMyBatisXml")
    public Object findAllByMyBatisXml() {
        return myBatisSysUserService.findAllByMyBatisXml();
    }

    @PostMapping(value="/findAllByMyBatisAno")
    public Object findAllByMyBatisAno() {
        return myBatisSysUserService.findAllByMyBatisAno();
    }

    @PostMapping(value="/saveSession")
    public Object saveSession(String name, HttpSession session) {
        session.setAttribute("name",name);
        return port;
    }

    @PostMapping(value="/getSession")
    public Object getSession(HttpSession session) {
        return port + ":" + session.getAttribute("name").toString();
    }
}