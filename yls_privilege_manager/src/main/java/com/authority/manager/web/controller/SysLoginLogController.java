package com.authority.manager.web.controller;


import com.authority.manager.web.model.log.SysLoginLogDO;
import com.authority.manager.web.service.SysLoginLogJpaService;
import com.yls.core.http.HttpConstants;
import com.yls.core.http.HttpResponseVO;
import com.yls.core.page.PageRequstQuery;
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
    private SysLoginLogJpaService sysLoginLogService;

    @ApiOperation(value = "删除登录日志")
    @DeleteMapping("loginLog")
    public HttpResponseVO delete(@ApiParam(value = "登录日志集合", required = true)@RequestBody List<SysLoginLogDO> records){
        sysLoginLogService.deleteAll(records);
        return HttpResponseVO.ok(HttpConstants.DELETE_OK);
    }

    @ApiOperation(value = "分页查询登录日志")
    @PostMapping("loginLog/lists")
    public HttpResponseVO lists(@ApiParam(value = "封装的分页请求对象", required = true)@RequestBody PageRequstQuery pageRequstQuery){
        PageRequest pageRequest = PageRequest.of(pageRequstQuery.getPageNum(), pageRequstQuery.getPageSize());
        Page page = sysLoginLogService.findByPage(pageRequest);
        return HttpResponseVO.ok(page);
    }
}
