package com.authority.manager.web.service.impl;

import com.authority.manager.web.dao.SysRoleMenuJpaDAO;
import com.authority.manager.web.service.SysRoleMenuJpaService;
import com.authority.manager.base.repository.BaseJpaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author yls
 * @Date 2020/4/5 12:04
 * @Description
 * @Version 1.0
 **/
@Transactional
@Service
public class SysRoleMenuJpaServiceImpl implements SysRoleMenuJpaService {
    @Autowired
    private SysRoleMenuJpaDAO sysRoleMenuDao;

    @Override
    public BaseJpaDAO getDao() {
        return sysRoleMenuDao;
    }
}
