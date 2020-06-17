package com.authority.manager.web.controller;


import com.authority.manager.web.model.SysLoginLog;
import com.authority.manager.web.service.SysLoginLogService;
import com.yls.core.http.HttpConstants;
import com.yls.core.http.HttpResult;
import com.yls.core.page.MyPageRequest;
import io.swagger.annotations.Api;
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
 * @Description 登录日志控制器
 * @Version 1.0
 **/
@RestController
@RequestMapping("sys_login_log")
@Api(tags = "登录日志接口")
public class SysLoginLogController {
    @Autowired
    private SysLoginLogService sysLoginLogService;

    @ApiOperation(value = "删除登录日志",notes = "删除登录日志")
    @PostMapping("/delete")
    public HttpResult delete(@RequestBody List<SysLoginLog> records){
        sysLoginLogService.deleteAll(records);
        return HttpResult.ok(HttpConstants.DELETE_OK);
    }

    @ApiOperation(value = "分页查询登录日志",notes = "分页查询登录日志")
    @PostMapping("/findByPage")
    public HttpResult findPage(@RequestBody MyPageRequest myPageRequest){
        PageRequest pageRequest = PageRequest.of(myPageRequest.getPageNum(), myPageRequest.getPageSize());
        Page page = sysLoginLogService.findByPage(pageRequest);
        return HttpResult.ok(page);
    }
}
