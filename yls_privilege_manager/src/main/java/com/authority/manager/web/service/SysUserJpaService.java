package com.authority.manager.web.service;

import com.authority.manager.web.model.SysUserDO;
import com.authority.manager.web.model.relation.SysUserRoleDO;
import com.authority.manager.base.repository.BaseJpaService;

import java.util.List;
import java.util.Set;

/**
 * @Author yls
 * @Date 2020/4/5 11:54
 * @Description
 * @Version 1.0
 **/
public interface SysUserJpaService extends BaseJpaService<SysUserDO,String> {

    SysUserDO findByName(String name);

    Set<String> findPermissions(String userName);

    List<SysUserRoleDO> findUserRoles(Integer userId);

    void saveUser(SysUserDO sysUserDO);

}
