package com.authority.manager.functions.service.impl;

import com.authority.manager.functions.dao.SysTestUserJpaDAO;
import com.authority.manager.functions.model.SysTestJpaUser;
import com.authority.manager.functions.service.JpaSysUserJpaService;
import com.yls.core.repository.BaseJpaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author yls
 * @Date 2020/4/5 12:04
 * @Description
 * @Version 1.0
 **/
@Transactional
@Service
public class JpaSysUserServiceImpl implements JpaSysUserJpaService {

    @Autowired
    private SysTestUserJpaDAO sysTestUserJpaDAO;

    @Override
    public BaseJpaDAO getDao() {
        return sysTestUserJpaDAO;
    }

    @Override
    public SysTestJpaUser addUser(SysTestJpaUser sysTestJpaUser) {
        return sysTestUserJpaDAO.save(sysTestJpaUser);
    }

    @Override
    public SysTestJpaUser updateUser(SysTestJpaUser sysTestJpaUser) {
        return sysTestUserJpaDAO.save(sysTestJpaUser);
    }

    @Override
    public void deleteUser(Integer id) {
         sysTestUserJpaDAO.deleteById(id);
    }

    @Override
    public void deleteUsers() {
        List<SysTestJpaUser> all = sysTestUserJpaDAO.findAll();
        sysTestUserJpaDAO.deleteAll(all);
    }


    @Override
    public List<SysTestJpaUser> findAll() {
        return sysTestUserJpaDAO.findAll();
    }
}
