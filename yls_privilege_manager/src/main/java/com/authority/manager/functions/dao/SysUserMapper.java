package com.authority.manager.functions.dao;

import com.authority.manager.functions.model.SysTestUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import java.util.List;

@Mapper
@Repository
public interface SysUserMapper extends BaseMapper<SysTestUser> {
    /**
     * 查询全部
     * @return
     */
    List<SysTestUser> findAllByMyBatisXml();
}