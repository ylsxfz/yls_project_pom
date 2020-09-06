package com.authority.manager.web.controller;

import com.authority.manager.web.model.SysMenu;
import com.authority.manager.web.service.SysMenuService;
import com.yls.core.http.HttpConstants;
import com.yls.core.http.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author yls
 * @Date 2020/4/5 12:21
 * @Description 菜单管理控制器
 * @Version 1.0
 **/
@RestController
@RequestMapping("sys_menu")
@Api(tags = "菜单管理接口")
public class SysMenuController {
    @Autowired
    private SysMenuService sysMenuService;

    @ApiOperation(value = "保存菜单记录")
    @PostMapping("/save")
    public HttpResult save(@ApiParam(value = "菜单对象", required = true)@RequestBody SysMenu record){
        sysMenuService.save(record);
        return HttpResult.ok(HttpConstants.SAVE_OK);
    }


    @ApiOperation(value = "删除菜单记录")
    @PostMapping("/delete")
    public HttpResult delete(@ApiParam(value = "菜单对象集合", required = true)@RequestBody List<SysMenu> records){
        sysMenuService.deleteAll(records);
        return HttpResult.ok(HttpConstants.DELETE_OK);
    }


    @ApiOperation(value = "查询左侧导航")
    @ApiImplicitParam(name = "userName",value = "用户名",required = true)
    @GetMapping(value="/findNavTree")
    public HttpResult findNavTree(@RequestParam String userName) {
        return HttpResult.ok(sysMenuService.findTree(userName, 1));
    }

    @ApiOperation(value = "查询菜单数据")
    @GetMapping("/findMenuTree")
    public HttpResult findMenuTree(){
        return HttpResult.ok(sysMenuService.findTree(null,0));
    }
}
