package com.authority.manager.functions.service.impl;

import com.authority.manager.functions.model.SysTestMybatisUser;
import com.authority.manager.functions.dao.SysUserMapper;
import com.authority.manager.functions.dao.SysUserByAnoMapper;
import com.authority.manager.functions.service.MyBatisSysUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBatisSysUserServiceImpl implements MyBatisSysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysUserByAnoMapper sysUserByAnoMapper;

    @Override
    public List<SysTestMybatisUser> findAllByMyBatisXml() {
        List<SysTestMybatisUser> sysTestMybatisUsers = sysUserMapper.selectList(null);
        System.err.println(sysTestMybatisUsers);
        List<SysTestMybatisUser> sysTestMybatisUserList = sysUserMapper.findAllByMyBatisXml();
        return sysTestMybatisUserList;
    }

    @Override
    public List<SysTestMybatisUser> findAllByMyBatisAno() {
        return sysUserByAnoMapper.findAllByMyBatisAno();
    }

    @Override
    public Integer addUser(SysTestMybatisUser sysTestMybatisUser) {
        int insert = sysUserMapper.insert(sysTestMybatisUser);
        return insert;
    }

    @Override
    public Integer updateUser(SysTestMybatisUser sysTestMybatisUser) {
        QueryWrapper<SysTestMybatisUser> queryWrapper = new QueryWrapper<SysTestMybatisUser>();
        queryWrapper.eq("id",1);
        int update = sysUserMapper.update(sysTestMybatisUser,queryWrapper);
        return update;
    }

    @Override
    public Integer deleteUser(Integer id) {
        return sysUserMapper.deleteById(id);
    }

    @Override
    public List<SysTestMybatisUser> findAll() {
        return sysUserMapper.selectList(null);
    }


}