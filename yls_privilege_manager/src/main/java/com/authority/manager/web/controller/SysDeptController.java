package com.authority.manager.web.controller;

import com.authority.manager.web.model.SysDept;
import com.authority.manager.web.service.SysDeptService;
import com.yls.core.http.HttpConstants;
import com.yls.core.http.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author yls
 * @Date 2020/4/5 12:21
 * @Description 部门管理控制器
 * @Version 1.0
 **/
@RestController
@RequestMapping("sys_dept")
@Api(tags = "部门接口")
public class SysDeptController {

    @Autowired
    private SysDeptService sysDeptService;

    @ApiOperation(value = "保存部门")
    @PostMapping("/save")
    public HttpResult save(@ApiParam(value = "部门对象", required = true)@RequestBody SysDept record){
        sysDeptService.save(record);
        return HttpResult.ok(HttpConstants.SAVE_OK);
    }

    @ApiOperation(value = "删除部门")
    @PostMapping("/delete")
    public HttpResult delete(@ApiParam(value = "部门对象集合", required = true)@RequestBody List<SysDept> records){
        sysDeptService.deleteAll(records);
        return HttpResult.ok(HttpConstants.DELETE_OK);
    }

    @ApiOperation(value = "查询部门树形数据")
    @GetMapping("/findTree")
    public HttpResult findPage(){
        return HttpResult.ok(sysDeptService.findDeptTree());
    }


}
