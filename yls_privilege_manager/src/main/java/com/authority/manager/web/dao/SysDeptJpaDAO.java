package com.authority.manager.web.dao;

import com.authority.manager.web.model.SysDeptDO;
import com.authority.manager.base.repository.BaseJpaDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author yls
 * @Date 2020/4/5 11:49
 * @Description
 * @Version 1.0
 **/
@Repository
public interface SysDeptJpaDAO extends BaseJpaDAO<SysDeptDO,Integer> {

    List<SysDeptJpaDAO> findByParentIdOrderByOrderNumAsc(String parentId);

}
