package com.authority.manager.functions.dao;

import com.authority.manager.functions.model.User;
import com.authority.manager.web.model.SysUserDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import java.util.List;

@Mapper
@Repository
public interface SysUserMapper extends BaseMapper<User> {
    /**
     * 查询全部
     * @return
     */
    List<SysUserDO> findAllByMyBatisXml();
}