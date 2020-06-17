package com.authority.manager.web.service.impl;

import com.authority.manager.contant.SysContants;
import com.authority.manager.web.dao.SysMenuDao;
import com.authority.manager.web.dao.SysRoleDao;
import com.authority.manager.web.dao.SysRoleMenuDao;
import com.authority.manager.web.model.SysMenu;
import com.authority.manager.web.model.SysRole;
import com.authority.manager.web.model.SysRoleMenu;
import com.authority.manager.web.service.SysRoleSerivce;
import com.yls.core.repository.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Author yls
 * @Date 2020/4/5 12:04
 * @Description
 * @Version 1.0
 **/
@Transactional
@Service
public class SysRoleServiceImpl implements SysRoleSerivce {
    @Autowired
    private SysRoleDao sysRoleDao;

    @Autowired
    private SysMenuDao sysMenuDao;

    @Autowired
    private SysRoleMenuDao sysRoleMenuDao;

    @Override
    public BaseDao getDao() {
        return sysRoleDao;
    }

    @Override
    public SysRole findByName(String name) {
        return sysRoleDao.findByName(name);
    }

    @Override
    public List<SysMenu> findRoleMenus(String roleId) {
        Optional<SysRole> sysRoleOptional = sysRoleDao.findById(roleId);
        if (sysRoleOptional.isPresent()){
            SysRole sysRole = sysRoleOptional.get();
            //如果是超级管理员，查询所有
            if (SysContants.ADMIN.equals(sysRole.getName())){
                return sysMenuDao.findAll();
            }else {
                List<SysRoleMenu> sysRoleMenus = sysRoleMenuDao.findByRoleId(roleId);
                List<String> menuids = new ArrayList<>();
                sysRoleMenus.forEach(sysRoleMenu -> {
                    menuids.add(sysRoleMenu.getMenuId());
                });
                return sysMenuDao.findAllById(menuids);
            }
        }else {
            return new ArrayList<>();
        }
    }

    @Override
    public  void saveRoleMenus(List<SysRoleMenu> records){
        //查询当前角色的所有权限
        List<SysRoleMenu> sysRoleMenus = sysRoleMenuDao.findByRoleId(records.get(0).getRoleId());
        //组装为map
        Map<String, SysRoleMenu> roleMenusMap = new HashMap<>();
        sysRoleMenus.forEach(sysRoleMenu -> {
            roleMenusMap.put(sysRoleMenu.getMenuId(),sysRoleMenu);
        });

        List<SysRoleMenu> addSysRoleMenus = new ArrayList<>();
        records.forEach(sysRoleMenu -> {
            if (!roleMenusMap.containsKey(sysRoleMenu.getMenuId())){
                addSysRoleMenus.add(sysRoleMenu);
            }else{
                roleMenusMap.remove(sysRoleMenu.getMenuId());
            };
        });
        Collection<SysRoleMenu> delSysRoleMenus = roleMenusMap.values();
        //新增权限
        sysRoleMenuDao.saveAll(addSysRoleMenus);
        //删除权限
        sysRoleMenuDao.deleteAll(delSysRoleMenus);
    }
}
