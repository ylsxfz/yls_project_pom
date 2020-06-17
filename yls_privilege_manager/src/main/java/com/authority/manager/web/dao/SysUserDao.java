package com.authority.manager.web.dao;

import com.authority.manager.web.model.SysUser;
import com.yls.core.repository.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * @Author yls
 * @Date 2020/4/5 11:54
 * @Description
 * @Version 1.0
 **/
@Repository
public interface SysUserDao extends BaseDao<SysUser,String> {
    //根据姓名查询
    SysUser findByName(String name);
}
