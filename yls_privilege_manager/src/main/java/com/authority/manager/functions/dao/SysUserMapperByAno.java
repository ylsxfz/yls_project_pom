package com.authority.manager.functions.dao;

import com.authority.manager.web.model.SysUserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SysUserMapperByAno{
    /**
     * 查询全部
     * @return
     */
    @Select("select * from sys_user")
    List<SysUserDO> findAllByMyBatisAno();
}