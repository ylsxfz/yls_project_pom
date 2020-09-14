package com.authority.manager.web.service;

import com.authority.manager.web.model.SysMenuDO;
import com.yls.core.repository.BaseService;

import java.util.List;

/**
 * @Author yls
 * @Date 2020/4/5 11:52
 * @Description
 * @Version 1.0
 **/
public interface SysMenuService extends BaseService<SysMenuDO,String> {
    List<SysMenuDO> findTree(String userName, int menuType);
}
