package com.authority.manager.web.service.impl;

import com.authority.manager.web.dao.SysMenuDAO;
import com.authority.manager.web.dao.SysUserDAO;
import com.authority.manager.web.dao.SysUserRoleDAO;
import com.authority.manager.web.model.SysMenuDO;
import com.authority.manager.web.model.SysUserDO;
import com.authority.manager.web.model.relation.SysUserRoleDO;
import com.authority.manager.web.service.SysUserService;
import com.yls.core.repository.BaseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author yls
 * @Date 2020/4/5 12:04
 * @Description
 * @Version 1.0
 **/
@Transactional
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserDAO sysUserDao;

    @Autowired
    private SysMenuDAO sysMenuDao;

    @Autowired
    private SysUserRoleDAO sysUserRoleDao;

    @Override
    public BaseDAO getDao() {
        return sysUserDao;
    }


    @Override
    public SysUserDO findByName(String name) {
        return sysUserDao.findByName(name);
    }

    @Override
    public Set<String> findPermissions(String userName) {
        Set<String> perms = new HashSet<>();
        List<SysMenuDO> sysMenuDOS = sysMenuDao.findAll();
        for(SysMenuDO sysMenuDO : sysMenuDOS) {
            if(sysMenuDO.getPerms() != null && !"".equals(sysMenuDO.getPerms())) {
                perms.add(sysMenuDO.getPerms());
            }
        }
        return perms;
    }

    @Override
    public List<SysUserRoleDO> findUserRoles(Integer userId) {
        return sysUserRoleDao.findByUserId(userId);
    }

}
