package com.authority.manager.web.controller;


import com.authority.manager.web.model.log.SysLog;
import com.authority.manager.web.service.SysLogService;
import com.yls.core.http.HttpConstants;
import com.yls.core.http.HttpResult;
import com.yls.core.page.MyPageRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author yls
 * @Date 2020/4/5 12:21
 * @Description 系统日志控制器
 * @Version 1.0
 **/
@RestController
@RequestMapping("sys_log")
@Api(tags = "系统日志接口")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    //权限管理
    @PreAuthorize("hasAuthority('sys:dict:delete')")
    @ApiOperation(value = "删除日志记录")
    @PostMapping("/delete")
    public HttpResult delete(@ApiParam(value = "日志对象集合", required = true)@RequestBody List<SysLog> records){
        sysLogService.deleteAll(records);
        return HttpResult.ok(HttpConstants.DELETE_OK);
    }

    @ApiOperation(value = "分页查询日志")
    @PostMapping("/findByPage")
    public HttpResult findPage(@ApiParam(value = "日志对象集合", required = true)@RequestBody MyPageRequest myPageRequest){
        PageRequest pageRequest = PageRequest.of(myPageRequest.getPageNum(), myPageRequest.getPageSize());
        Page page = sysLogService.findByPage(pageRequest);
        return HttpResult.ok(page);
    }

}
