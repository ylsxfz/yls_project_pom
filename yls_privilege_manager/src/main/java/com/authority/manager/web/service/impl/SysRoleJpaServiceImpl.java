package com.authority.manager.web.service.impl;

import com.authority.manager.contant.SysContants;
import com.authority.manager.web.dao.SysMenuJpaDAO;
import com.authority.manager.web.dao.SysRoleJpaDAO;
import com.authority.manager.web.dao.SysRoleMenuJpaDAO;
import com.authority.manager.web.model.SysMenuDO;
import com.authority.manager.web.model.SysRoleDO;
import com.authority.manager.web.model.relation.SysRoleMenuDO;
import com.authority.manager.web.service.SysRoleSerivce;
import com.yls.core.repository.BaseJpaDAO;
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
public class SysRoleJpaServiceImpl implements SysRoleSerivce {
    @Autowired
    private SysRoleJpaDAO sysRoleDao;

    @Autowired
    private SysMenuJpaDAO sysMenuDao;

    @Autowired
    private SysRoleMenuJpaDAO sysRoleMenuDao;

    @Override
    public BaseJpaDAO getDao() {
        return sysRoleDao;
    }

    @Override
    public SysRoleDO findByName(String name) {
        return sysRoleDao.findByName(name);
    }

    @Override
    public List<SysMenuDO> findRoleMenus(Integer roleId) {
        Optional<SysRoleDO> sysRoleOptional = sysRoleDao.findById(roleId);
        if (sysRoleOptional.isPresent()){
            SysRoleDO sysRoleDO = sysRoleOptional.get();
            //如果是超级管理员，查询所有
            if (SysContants.ADMIN.equals(sysRoleDO.getName())){
                return sysMenuDao.findAll();
            }else {
                List<SysRoleMenuDO> sysRoleMenuDOS = sysRoleMenuDao.findByRoleId(roleId);
                List<Integer> menuids = new ArrayList<>();
                sysRoleMenuDOS.forEach(sysRoleMenu -> {
                    menuids.add(sysRoleMenu.getMenuId());
                });
                return sysMenuDao.findAllById(menuids);
            }
        }else {
            return new ArrayList<>();
        }
    }

    @Override
    public  void saveRoleMenus(List<SysRoleMenuDO> records){
        //查询当前角色的所有权限
        List<SysRoleMenuDO> sysRoleMenuDOS = sysRoleMenuDao.findByRoleId(records.get(0).getRoleId());
        //组装为map
        Map<Integer, SysRoleMenuDO> roleMenusMap = new HashMap<>();
        sysRoleMenuDOS.forEach(sysRoleMenu -> {
            roleMenusMap.put(sysRoleMenu.getMenuId(),sysRoleMenu);
        });

        List<SysRoleMenuDO> addSysRoleMenuDOS = new ArrayList<>();
        records.forEach(sysRoleMenu -> {
            if (!roleMenusMap.containsKey(sysRoleMenu.getMenuId())){
                addSysRoleMenuDOS.add(sysRoleMenu);
            }else{
                roleMenusMap.remove(sysRoleMenu.getMenuId());
            };
        });
        Collection<SysRoleMenuDO> delSysRoleMenuDOS = roleMenusMap.values();
        //新增权限
        sysRoleMenuDao.saveAll(addSysRoleMenuDOS);
        //删除权限
        sysRoleMenuDao.deleteAll(delSysRoleMenuDOS);
    }
}
