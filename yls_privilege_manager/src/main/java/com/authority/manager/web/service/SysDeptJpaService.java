package com.authority.manager.web.service;

import com.authority.manager.web.model.SysDeptDO;
import com.yls.core.repository.BaseJpaService;

import java.util.List;

/**
 * @Author yls
 * @Date 2020/4/5 11:49
 * @Description
 * @Version 1.0
 **/
public interface SysDeptJpaService extends BaseJpaService<SysDeptDO,String> {
    List<SysDeptDO> findDeptTree();
}
