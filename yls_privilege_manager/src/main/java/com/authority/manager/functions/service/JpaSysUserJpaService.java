package com.authority.manager.functions.service;

import com.authority.manager.functions.model.SysTestJpaUser;
import com.authority.manager.web.model.SysDeptDO;
import com.authority.manager.base.repository.BaseJpaService;

import java.util.List;

public interface JpaSysUserJpaService extends BaseJpaService<SysDeptDO,Integer> {
    /**
     * 添加用户
     * @param sysTestJpaUser
     * @return
     */
    SysTestJpaUser addUser(SysTestJpaUser sysTestJpaUser);

    /**
     * 修改用户
     * @param sysTestJpaUser
     * @return
     */
    SysTestJpaUser updateUser(SysTestJpaUser sysTestJpaUser);

    /**
     * 删除用户
     * @param id id
     * @return
     */
    void deleteUser(Integer id);


    /**
     * 删除用户
     * @return
     */
    void deleteUsers();

    /**
     * 查找所有用户：mybatis的xml
     */
    List<SysTestJpaUser> findAll();
}