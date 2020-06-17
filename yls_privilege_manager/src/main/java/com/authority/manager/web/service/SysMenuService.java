package com.authority.manager.web.service;

import com.authority.manager.web.model.SysMenu;
import com.yls.core.repository.BaseService;

import java.util.List;

/**
 * @Author yls
 * @Date 2020/4/5 11:52
 * @Description
 * @Version 1.0
 **/
public interface SysMenuService extends BaseService<SysMenu,String> {
    List<SysMenu> findTree(String userName, int menuType);
}
