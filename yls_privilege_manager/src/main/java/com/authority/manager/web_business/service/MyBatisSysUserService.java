package com.authority.manager.web_business.service;

import com.authority.manager.web.model.SysUser;

import java.util.List;

public interface MyBatisSysUserService {

    /**
     * 查找所有用户：mybatis的xml
     */
    List<SysUser> findAllByMyBatisXml();

    /**
     * 查找所有用户：通过注解方式
     */
    List<SysUser> findAllByMyBatisAno();


}