package com.authority.manager.functions.service;

import com.authority.manager.web.model.SysUserDO;

import java.util.List;

public interface MyBatisSysUserService {

    /**
     * 查找所有用户：mybatis的xml
     */
    List<SysUserDO> findAllByMyBatisXml();

    /**
     * 查找所有用户：通过注解方式
     */
    List<SysUserDO> findAllByMyBatisAno();


}