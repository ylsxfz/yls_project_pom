package com.authority.manager.functions.dao;

import com.authority.manager.functions.model.SysTestMybatisUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SysUserByAnoMapper {
    /**
     * 查询全部
     * @return
     */
    @Select("select * from sys_test_mybatis_user")
    List<SysTestMybatisUser> findAllByMyBatisAno();
}