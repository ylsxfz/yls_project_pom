package com.authority.manager.web.dao;

import com.authority.manager.web.model.relation.SysRoleMenuDO;
import com.yls.core.repository.BaseDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author yls
 * @Date 2020/4/5 11:54
 * @Description
 * @Version 1.0
 **/
@Repository
public interface SysRoleMenuDAO extends BaseDAO<SysRoleMenuDO,Integer> {

    List<SysRoleMenuDO> findByRoleId(Integer roleId);

    List<SysRoleMenuDO> findByRoleIdIn(List<Integer> roleIds);
}
