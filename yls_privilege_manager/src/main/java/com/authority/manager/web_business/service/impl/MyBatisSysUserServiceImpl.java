package com.authority.manager.web_business.service.impl;

import com.authority.manager.web.model.SysUser;
import com.authority.manager.web_business.dao.SysUserMapper;
import com.authority.manager.web_business.dao.SysUserMapperByAno;
import com.authority.manager.web_business.service.MyBatisSysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBatisSysUserServiceImpl implements MyBatisSysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysUserMapperByAno sysUserMapperByAno;

    @Override
    public List<SysUser> findAllByMyBatisXml() {
        return sysUserMapper.findAllByMyBatisXml();
    }

    @Override
    public List<SysUser> findAllByMyBatisAno() {
        return sysUserMapperByAno.findAllByMyBatisAno();
    }


}