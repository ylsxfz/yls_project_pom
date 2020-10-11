package com.authority.manager.web.controller;


import com.authority.manager.web.model.log.SysLoginLogDO;
import com.authority.manager.web.service.SysLoginLogService;
import com.yls.core.http.HttpConstants;
import com.yls.core.http.HttpResultVO;
import com.yls.core.page.PageQuery;
import io.swagger.annotations.Api;
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
 * @Description 登录日志控制器
 * @Version 1.0
 **/
@RestController
@RequestMapping("sys")
@Api(tags = "登录日志接口")
public class SysLoginLogController {
    @Autowired
    private SysLoginLogService sysLoginLogService;

    @ApiOperation(value = "删除登录日志")
    @DeleteMapping("loginLog")
    public HttpResultVO delete(@ApiParam(value = "登录日志集合", required = true)@RequestBody List<SysLoginLogDO> records){
        sysLoginLogService.deleteAll(records);
        return HttpResultVO.ok(HttpConstants.DELETE_OK);
    }

    @ApiOperation(value = "分页查询登录日志")
    @PostMapping("loginLog/lists")
    public HttpResultVO lists(@ApiParam(value = "封装的分页请求对象", required = true)@RequestBody PageQuery pageQuery){
        PageRequest pageRequest = PageRequest.of(pageQuery.getPageNum(), pageQuery.getPageSize());
        Page page = sysLoginLogService.findByPage(pageRequest);
        return HttpResultVO.ok(page);
    }
}
