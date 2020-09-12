package com.authority.manager.web.dao;

import com.authority.manager.web.model.SysDept;
import com.yls.core.repository.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author yls
 * @Date 2020/4/5 11:49
 * @Description
 * @Version 1.0
 **/
@Repository
public interface SysDeptDao extends BaseDao<SysDept,Integer> {

    List<SysDeptDao> findByParentIdOrderByOrderNumAsc(String parentId);

}
