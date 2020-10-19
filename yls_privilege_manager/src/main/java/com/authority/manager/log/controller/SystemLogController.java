package com.authority.manager.log.controller;


import com.authority.manager.log.annotation.SystemControllerLog;
import com.authority.manager.log.dao.SystemLogJpaDAO;
import com.authority.manager.log.model.SystemLogDO;
import com.yls.core.http.HttpResponseVO;
import com.yls.core.page.PageRequstQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("log")
@Api(tags = "日志接口")
public class SystemLogController {

    @Autowired
    private SystemLogJpaDAO systemLogJpaDAO;

    @SystemControllerLog(operation = "分页查询日志")
    @ApiOperation(value = "分页查询日志")
    @PostMapping("log/lists")
    public HttpResponseVO lists(@ApiParam(value = "日志对象集合", required = true)@RequestBody PageRequstQuery pageRequstQuery){
        List<SystemLogDO> systemLogDOS = systemLogJpaDAO.findAll();
        return HttpResponseVO.ok(systemLogDOS);
    }

}
