package com.authority.manager.web.service;

import com.authority.manager.web.model.SysMenuDO;
import com.authority.manager.web.model.SysRoleDO;
import com.authority.manager.web.model.relation.SysRoleMenuDO;
import com.yls.core.repository.BaseService;

import java.util.List;

/**
 * @Author yls
 * @Date 2020/4/5 11:52
 * @Description
 * @Version 1.0
 **/
public interface SysRoleSerivce extends BaseService<SysRoleDO,String> {

    SysRoleDO findByName(String name);

    List<SysMenuDO> findRoleMenus(Integer roleId);

    void saveRoleMenus(List<SysRoleMenuDO> records);
}
