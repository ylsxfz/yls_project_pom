package com.authority.manager.web_business.service;

import com.authority.manager.web_business.model.SysUser;

import java.util.List;

public interface SysUserService {

    /**
     * 查找所有用户
     * @return
     */
    List<SysUser> findAll();

}