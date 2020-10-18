package com.authority.manager.web.service.impl;

import com.authority.manager.web.dao.SysRoleDeptJpaDAO;
import com.authority.manager.web.service.SysRoleDeptJpaService;
import com.yls.core.repository.BaseJpaDAO;
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
public class SysRoleDeptJpaServiceImpl implements SysRoleDeptJpaService {
    @Autowired
    private SysRoleDeptJpaDAO sysRoleDeptDao;

    @Override
    public BaseJpaDAO getDao() {
        return sysRoleDeptDao;
    }
}
