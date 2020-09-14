package com.authority.manager.web.controller;


import com.authority.manager.web.model.SysConfigDO;
import com.authority.manager.web.service.SysConfigService;
import com.yls.core.http.HttpConstants;
import com.yls.core.http.HttpResultVO;
import com.yls.core.page.MyPageQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author yls
 * @Date 2020/4/5 12:21
 * @Description 系统配置控制器
 * @Version 1.0
 **/
@RestController
@RequestMapping("sys_config")
@Api(tags = "系统配置接口")
public class SysConfigController {

    @Autowired
    private SysConfigService sysConfigService;

    @ApiOperation(value = "保存系统配置")
    @PostMapping("/save")
    public HttpResultVO save(@ApiParam(value = "系统对象", required = true) @RequestBody SysConfigDO record){
        sysConfigService.save(record);
        return HttpResultVO.ok(HttpConstants.SAVE_OK);
    }


    @ApiOperation(value = "删除系统配置")
    @ApiImplicitParam(required = true)
    @PostMapping("/delete")
    public HttpResultVO delete(@ApiParam(value = "系统对象集合", required = true)@RequestBody List<SysConfigDO> records){
        sysConfigService.deleteAll(records);
        return HttpResultVO.ok(HttpConstants.DELETE_OK);
    }


    @ApiOperation(value = "分页查询系统配置")
    @PostMapping("/findByPage")
    public HttpResultVO findPage(@ApiParam(value = "分页请求封装",required = true)@RequestBody MyPageQuery myPageQuery){
        PageRequest pageRequest = PageRequest.of(myPageQuery.getPageNum(), myPageQuery.getPageSize());
        Page page = sysConfigService.findByPage(pageRequest);
        return HttpResultVO.ok(page);
    }

}
