package com.authority.manager.web.service;

import com.authority.manager.web.model.SysUser;
import com.authority.manager.web.model.SysUserRole;
import com.yls.core.repository.BaseService;

import java.util.List;
import java.util.Set;

/**
 * @Author yls
 * @Date 2020/4/5 11:54
 * @Description
 * @Version 1.0
 **/
public interface SysUserService extends BaseService<SysUser,String> {

    SysUser findByName(String name);

    Set<String> findPermissions(String userName);

    List<SysUserRole> findUserRoles(String userId);

}
