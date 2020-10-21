package com.authority.manager.web.dao;

import com.authority.manager.web.model.SysDictDO;
import com.authority.manager.base.repository.BaseJpaDAO;
import org.springframework.stereotype.Repository;

/**
 * @Author yls
 * @Date 2020/4/5 11:50
 * @Description
 * @Version 1.0
 **/
@Repository
public interface SysDictJpaDAO extends BaseJpaDAO<SysDictDO,Integer> {
}
