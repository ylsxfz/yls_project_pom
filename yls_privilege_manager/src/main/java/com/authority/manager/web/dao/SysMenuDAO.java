package com.authority.manager.web.dao;

import com.authority.manager.web.model.SysMenuDO;
import com.yls.core.repository.BaseDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author yls
 * @Date 2020/4/5 11:52
 * @Description
 * @Version 1.0
 **/
@Repository
public interface SysMenuDAO extends BaseDAO<SysMenuDO,Integer> {

    List<SysMenuDO> findByTypeNot(int menuType);
}
