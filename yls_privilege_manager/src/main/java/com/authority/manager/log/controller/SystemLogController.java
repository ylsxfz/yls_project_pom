package com.authority.manager.log.controller;


import com.authority.manager.base.http.HttpResponseVO;
import com.authority.manager.base.page.PageRequstQuery;
import com.authority.manager.base.repository.sql.BaseSQLServiceImpl;
import com.authority.manager.component.jsonfilter.JsonFieldFilter;
import com.authority.manager.log.annotation.SystemControllerLog;
import com.authority.manager.log.dao.SystemLogJpaDAO;
import com.authority.manager.log.model.SystemLogDO;
import com.authority.manager.log.service.SystemLogService;
import com.yls.common.utils.DateUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

/**
 * @Author yls
 * @Date 2020/4/5 12:21
 * @Description 系统日志控制器
 * @Version 1.0
 **/
@Controller // 由于该类中的方法需要在返回前台json时屏蔽某些字段
@RequestMapping("log")
@Api(tags = "日志接口")
public class SystemLogController {

    @Autowired
    private SystemLogJpaDAO systemLogJpaDAO;

    @Autowired
    private SystemLogService systemLogService;

    @Autowired
    private BaseSQLServiceImpl<SystemLogDO> baseSQLService;

    @SystemControllerLog(operation = "分页查询日志")
    @ApiOperation(value = "分页查询日志")
    @JsonFieldFilter(type = SystemLogDO.class,exclude = "id")
    @PostMapping("log/lists")
    public HttpResponseVO lists(@ApiParam(value = "日志对象集合", required = true) @RequestBody PageRequstQuery pageRequstQuery) {
        List<SystemLogDO> systemLogDOS = systemLogJpaDAO.findAll();
        return HttpResponseVO.ok(systemLogDOS);
    }


    @ApiOperation(value = "添加日志")
    @PostMapping("log/addSystemLog")
    public HttpResponseVO addSystemLog() {
        // 获取当天的日期
        String yyyy_mm_dd = DateUtils.toString(new Date(), "yyyy_MM_dd");
        String createSql = "CREATE TABLE yls_privilege_log.system_log_"+yyyy_mm_dd+" LIKE yls_privilege_log.system_log";
        String insetSql = "INSERT INTO `yls_privilege_log`.`system_log_"+yyyy_mm_dd+"`(`create_by`, `create_time`, `is_deleted`, `update_by`, `update_time`," +
                " `exception_log`, `ip`, `method`, `operation`, `params`, `request_method`, `request_uri`, `type`, `user_name`)" +
                " VALUES ('admin', '2020-10-20 00:44:49', 0, 'admin', '2020-10-20 00:44:49', '无异常', '192.168.159.1'," +
                " 'com.authority.manager.log.controller.SystemLogController.lists', " +
                "'分页查询日志', '[{\\\"pageNum\\\":0,\\\"pageSize\\\":6,\\\"params\\\":[{\\\"field\\\":\\\"id\\\",\\\"value\\\":\\\"123456\\\"}]}]', " +
                "'POST', '/log/log/lists', 'info', 'admin')";
        System.out.println(insetSql);
        try {
            // 插入日志
            baseSQLService.insertLogByDay(insetSql);
        }catch (Exception e){
            e.printStackTrace();
            e.getMessage();
            // 如果表不存在，创建表
             baseSQLService.insertLogByDay(createSql);
            // 创建表后，再插入数据库
             baseSQLService.insertLogByDay(insetSql);

        }
        return null;
    }
}
