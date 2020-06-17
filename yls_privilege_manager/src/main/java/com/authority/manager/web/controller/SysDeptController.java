package com.authority.manager.web.controller;

import com.authority.manager.web.model.SysDept;
import com.authority.manager.web.service.SysDeptService;
import com.yls.core.http.HttpConstants;
import com.yls.core.http.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "保存部门",notes = "保存部门")
    @PostMapping("/save")
    public HttpResult save(@RequestBody SysDept record){
        sysDeptService.save(record);
        return HttpResult.ok(HttpConstants.SAVE_OK);
    }

    @ApiOperation(value = "删除部门",notes = "批量删除")
    @PostMapping("/delete")
    public HttpResult delete(@RequestBody List<SysDept> records){
        sysDeptService.deleteAll(records);
        return HttpResult.ok(HttpConstants.DELETE_OK);
    }

    @ApiOperation(value = "查询部门树形结构的数据",notes = "树形结构的数据")
    @GetMapping("/findTree")
    public HttpResult findPage(){
        return HttpResult.ok(sysDeptService.findDeptTree());
    }


}
