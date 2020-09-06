package com.authority.manager.web.service.impl;

import com.authority.manager.web.dao.SysMenuDao;
import com.authority.manager.web.dao.SysUserDao;
import com.authority.manager.web.dao.SysUserRoleDao;
import com.authority.manager.web.model.SysMenu;
import com.authority.manager.web.model.SysUser;
import com.authority.manager.web.model.relation.SysUserRole;
import com.authority.manager.web.service.SysUserService;
import com.yls.core.repository.BaseDao;
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
    private SysUserDao sysUserDao;

    @Autowired
    private SysMenuDao sysMenuDao;

    @Autowired
    private SysUserRoleDao sysUserRoleDao;

    @Override
    public BaseDao getDao() {
        return sysUserDao;
    }


    @Override
    public SysUser findByName(String name) {
        return sysUserDao.findByName(name);
    }

    @Override
    public Set<String> findPermissions(String userName) {
        Set<String> perms = new HashSet<>();
        List<SysMenu> sysMenus = sysMenuDao.findAll();
        for(SysMenu sysMenu:sysMenus) {
            if(sysMenu.getPerms() != null && !"".equals(sysMenu.getPerms())) {
                perms.add(sysMenu.getPerms());
            }
        }
        return perms;
    }

    @Override
    public List<SysUserRole> findUserRoles(Integer userId) {
        return sysUserRoleDao.findByUserId(userId);
    }

}
