package com.authority.manager.web.controller;


import com.authority.manager.web.model.log.SysLogDO;
import com.authority.manager.web.service.SysLogService;
import com.yls.core.http.HttpConstants;
import com.yls.core.http.HttpResultVO;
import com.yls.core.page.MyPageQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author yls
 * @Date 2020/4/5 12:21
 * @Description 系统日志控制器
 * @Version 1.0
 **/
@RestController
@RequestMapping("sys")
@Api(tags = "系统日志接口")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    //权限管理
    @PreAuthorize("hasAuthority('sys:dict:delete')")
    @ApiOperation(value = "删除日志记录")
    @DeleteMapping("log")
    public HttpResultVO delete(@ApiParam(value = "日志对象集合", required = true)@RequestBody List<SysLogDO> records){
        sysLogService.deleteAll(records);
        return HttpResultVO.ok(HttpConstants.DELETE_OK);
    }

    @ApiOperation(value = "分页查询日志")
    @PostMapping("log/lists")
    public HttpResultVO lists(@ApiParam(value = "日志对象集合", required = true)@RequestBody MyPageQuery myPageQuery){
        PageRequest pageRequest = PageRequest.of(myPageQuery.getPageNum(), myPageQuery.getPageSize());
        Page page = sysLogService.findByPage(pageRequest);
        return HttpResultVO.ok(page);
    }

}
