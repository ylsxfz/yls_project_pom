package com.authority.manager.functions.dao;

import com.authority.manager.web.model.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import java.util.List;

@Mapper
@Repository
public interface SysUserMapper extends tk.mybatis.mapper.common.Mapper<SysUser> {
    /**
     * 查询全部
     * @return
     */
    List<SysUser> findAllByMyBatisXml();
}