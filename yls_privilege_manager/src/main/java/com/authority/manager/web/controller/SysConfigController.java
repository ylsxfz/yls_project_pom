package com.authority.manager.web.controller;


import com.authority.manager.web.model.SysConfig;
import com.authority.manager.web.service.SysConfigService;
import com.yls.core.http.HttpConstants;
import com.yls.core.http.HttpResult;
import com.yls.core.page.MyPageRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "保存系统配置",notes = "系统配置记录")
    @ApiImplicitParam(paramType = "path",name = "record",value = "系统配置记录",required = true)
    @PostMapping("/save")
    public HttpResult save(@RequestBody SysConfig record){
        sysConfigService.save(record);
        return HttpResult.ok(HttpConstants.SAVE_OK);
    }


    @ApiOperation(value = "删除系统配置",notes = "批量删除")
    @ApiImplicitParam(paramType = "path",name = "records",value = "系统配置记录集合",required = true)
    @PostMapping("/delete")
    public HttpResult delete(@RequestBody List<SysConfig> records){
        sysConfigService.deleteAll(records);
        return HttpResult.ok(HttpConstants.DELETE_OK);
    }


    @ApiOperation(value = "分页查询系统配置记录",notes = "根据分页参数分页查询系统配置记录")
    @PostMapping("/findByPage")
    public HttpResult findPage(@RequestBody MyPageRequest myPageRequest){
        PageRequest pageRequest = PageRequest.of(myPageRequest.getPageNum(), myPageRequest.getPageSize());
        Page page = sysConfigService.findByPage(pageRequest);
        return HttpResult.ok(page);
    }

}
