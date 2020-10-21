package com.authority.manager.web.controller;


import com.authority.manager.web.model.SysConfigDO;
import com.authority.manager.web.service.SysConfigJpaService;
import com.authority.manager.base.http.HttpConstants;
import com.authority.manager.base.http.HttpResponseVO;
import com.authority.manager.base.page.PageRequstQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author yls
 * @Date 2020/4/5 12:21
 * @Description 系统配置控制器
 * @Version 1.0
 **/
@RestController
@RequestMapping("sys")
@Api(tags = "系统配置接口")
public class SysConfigController {

    @Autowired
    private SysConfigJpaService sysConfigService;

    @ApiOperation(value = "保存系统配置")
    @PostMapping("config")
    public HttpResponseVO save(@ApiParam(value = "系统对象", required = true) @RequestBody SysConfigDO record){
        sysConfigService.save(record);
        return HttpResponseVO.ok(HttpConstants.SAVE_OK);
    }


    @ApiOperation(value = "删除系统配置")
    @ApiImplicitParam(required = true)
    @DeleteMapping("/config")
    public HttpResponseVO delete(@ApiParam(value = "系统对象集合", required = true)@RequestBody List<SysConfigDO> records){
        sysConfigService.deleteAll(records);
        return HttpResponseVO.ok(HttpConstants.DELETE_OK);
    }


    @ApiOperation(value = "分页查询系统配置")
    @PostMapping("config/lists")
    public HttpResponseVO lists(@ApiParam(value = "分页请求封装",required = true)@RequestBody PageRequstQuery pageRequstQuery){
        PageRequest pageRequest = PageRequest.of(pageRequstQuery.getPageNum(), pageRequstQuery.getPageSize());
        Page page = sysConfigService.findByPage(pageRequest);
        return HttpResponseVO.ok(page);
    }

}
