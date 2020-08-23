package com.authority.manager.web_business.service.impl;

import com.authority.manager.web_business.dao.SysUserMapper;
import com.authority.manager.web_business.model.SysUser;
import com.authority.manager.web_business.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {
    
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> findAll() {
        return sysUserMapper.findAll();
    }
}