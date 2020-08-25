package com.authority.manager.functions.controller;

import com.authority.manager.functions.service.MyBatisSysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("user")
public class MyBatisSysUserController {

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
}