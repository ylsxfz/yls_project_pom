package com.authority.manager.functions.service;

import com.authority.manager.functions.model.SysTestMybatisUser;

import java.util.List;

public interface MyBatisSysUserService {

    /**
     * 查找所有用户：mybatis的xml
     */
    List<SysTestMybatisUser> findAllByMyBatisXml();

    /**
     * 查找所有用户：通过注解方式
     */
    List<SysTestMybatisUser> findAllByMyBatisAno();

    /**
     * 添加用户
     * @param sysTestMybatisUser
     * @return
     */
    Integer addUser(SysTestMybatisUser sysTestMybatisUser);

    /**
     * 修改用户
     * @param sysTestMybatisUser
     * @return
     */
    Integer updateUser(SysTestMybatisUser sysTestMybatisUser);

    /**
     * 删除用户
     * @param id id
     * @return
     */
    Integer deleteUser(Integer id);

    /**
     * 查找所有用户：mybatis的xml
     */
    List<SysTestMybatisUser> findAll();
}