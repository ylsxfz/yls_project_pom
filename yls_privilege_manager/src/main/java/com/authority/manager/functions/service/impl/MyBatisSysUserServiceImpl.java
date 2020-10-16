package com.authority.manager.functions.service.impl;

import com.authority.manager.functions.model.SysTestUser;
import com.authority.manager.functions.dao.SysUserMapper;
import com.authority.manager.functions.dao.SysUserMapperByAno;
import com.authority.manager.functions.service.MyBatisSysUserService;
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
    public List<SysTestUser> findAllByMyBatisXml() {
        List<SysTestUser> sysTestUsers = sysUserMapper.selectList(null);
        System.err.println(sysTestUsers);
        List<SysTestUser> sysTestUserList = sysUserMapper.findAllByMyBatisXml();
        return sysTestUserList;
    }

    @Override
    public List<SysTestUser> findAllByMyBatisAno() {
        return sysUserMapperByAno.findAllByMyBatisAno();
    }


}