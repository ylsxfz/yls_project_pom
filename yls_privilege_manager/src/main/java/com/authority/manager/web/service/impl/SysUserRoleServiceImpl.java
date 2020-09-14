package com.authority.manager.web.service.impl;

import com.authority.manager.web.dao.SysUserRoleDAO;
import com.authority.manager.web.service.SysUserRoleService;
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
public class SysUserRoleServiceImpl implements SysUserRoleService {
    @Autowired
    private SysUserRoleDAO sysUserRoleDao;
    @Override
    public BaseDao getDao() {
        return sysUserRoleDao;
    }


}
