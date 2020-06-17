package com.authority.manager.web.service.impl;

import com.authority.manager.web.dao.SysRoleDeptDao;
import com.authority.manager.web.service.SysRoleDeptService;
import com.yls.core.repository.BaseDao;
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
public class SysRoleDeptServiceImpl implements SysRoleDeptService {
    @Autowired
    private SysRoleDeptDao sysRoleDeptDao;

    @Override
    public BaseDao getDao() {
        return sysRoleDeptDao;
    }
}
