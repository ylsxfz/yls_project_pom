package com.authority.manager.web.service;

import com.authority.manager.web.model.SysMenu;
import com.authority.manager.web.model.SysRole;
import com.authority.manager.web.model.SysRoleMenu;
import com.yls.core.repository.BaseService;

import java.util.List;

/**
 * @Author yls
 * @Date 2020/4/5 11:52
 * @Description
 * @Version 1.0
 **/
public interface SysRoleSerivce extends BaseService<SysRole,String> {

    SysRole findByName(String name);

    List<SysMenu> findRoleMenus(String roleId);

    void saveRoleMenus(List<SysRoleMenu> records);
}
