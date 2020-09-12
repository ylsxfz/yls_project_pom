package com.authority.manager.web.dao;

import com.authority.manager.web.model.relation.SysUserRole;
import com.yls.core.repository.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author yls
 * @Date 2020/4/5 11:57
 * @Description
 * @Version 1.0
 **/
@Repository
public interface SysUserRoleDao extends BaseDao<SysUserRole,Integer> {
    //根据userid查询
    List<SysUserRole> findByUserId(Integer userId);
}
