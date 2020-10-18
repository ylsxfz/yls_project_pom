package com.authority.manager.web.service.impl;

import com.authority.manager.contant.SysContants;
import com.authority.manager.web.dao.SysMenuJpaDAO;
import com.authority.manager.web.dao.SysRoleMenuJpaDAO;
import com.authority.manager.web.dao.SysUserJpaDAO;
import com.authority.manager.web.dao.SysUserRoleJpaDAO;
import com.authority.manager.web.model.SysMenuDO;
import com.authority.manager.web.model.SysUserDO;
import com.authority.manager.web.model.relation.SysRoleMenuDO;
import com.authority.manager.web.model.relation.SysUserRoleDO;
import com.authority.manager.web.service.SysUserJpaService;
import com.yls.core.repository.BaseJpaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
public class SysUserJpaServiceImpl implements SysUserJpaService {
    @Autowired
    private SysUserJpaDAO sysUserDao;

    @Autowired
    private SysMenuJpaDAO sysMenuDao;

    @Autowired
    private SysUserRoleJpaDAO sysUserRoleDao;

    @Autowired
    private SysRoleMenuJpaDAO sysRoleMenuDAO;

    @Override
    public BaseJpaDAO getDao() {
        return sysUserDao;
    }


    @Override
    public SysUserDO findByName(String name) {
        return sysUserDao.findByName(name);
    }


    @Override
    public Set<String> findPermissions(String userName) {
        /**
         * 根据用户名查询用户
         */
        SysUserDO sysUserDO = sysUserDao.findByName(userName);
        int userDOId = sysUserDO.getId();
        Set<String> perms = new HashSet<>();
        List<SysMenuDO> sysMenuDOS = new ArrayList<>();
        // 超级管理员
        if (SysContants.ADMIN.equals(sysUserDO.getName())){
            sysMenuDOS  = sysMenuDao.findAll();
        }else{
            /**
             * 根据用户id查询用户角色id集合
             */
            List<SysUserRoleDO> userRoleDOS = sysUserRoleDao.findByUserId(userDOId);
            List<Integer> ids = new ArrayList<>();
            userRoleDOS.forEach(sysUserRoleDO -> {
                ids.add(sysUserRoleDO.getRoleId());
            });
            /**
             * 根据角色id查询所有的菜单
             */
            List<SysRoleMenuDO> sysRoleMenuDOS = sysRoleMenuDAO.findByRoleIdIn(ids);
            List<Integer> menuIds = new ArrayList<>();
            sysRoleMenuDOS.forEach(sysRoleMenuDO -> {
                menuIds.add(sysRoleMenuDO.getMenuId());
            });
            sysMenuDOS = sysMenuDao.findAllById(menuIds);

        }
        /**
         * 组装所有的权限信息
         */
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

    @Override
    public void saveUser(SysUserDO sysUserDO) {
        //保存用户信息
        sysUserDao.save(sysUserDO);

        //删除之前的权限
        List<SysUserRoleDO> sysUserRoleDOs = sysUserRoleDao.findByUserId(sysUserDO.getId());
        sysUserRoleDao.deleteAll(sysUserRoleDOs);

        //保存用户角色
        sysUserRoleDao.saveAll(sysUserDO.getUserRoles());
    }

}
