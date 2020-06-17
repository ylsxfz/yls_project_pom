package com.authority.manager.web.controller;

import com.authority.manager.web.model.SysMenu;
import com.authority.manager.web.service.SysMenuService;
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
 * @Description 菜单管理控制器
 * @Version 1.0
 **/
@RestController
@RequestMapping("sys_menu")
@Api(tags = "菜单管理接口")
public class SysMenuController {
    @Autowired
    private SysMenuService sysMenuService;

    @ApiOperation(value = "保存菜单记录",notes = "保存菜单记录")
    @PostMapping("/save")
    public HttpResult save(@RequestBody SysMenu record){
        sysMenuService.save(record);
        return HttpResult.ok(HttpConstants.SAVE_OK);
    }


    @ApiOperation(value = "删除菜单记录",notes = "删除菜单记录")
    @PostMapping("/delete")
    public HttpResult delete(@RequestBody List<SysMenu> records){
        sysMenuService.deleteAll(records);
        return HttpResult.ok(HttpConstants.DELETE_OK);
    }


    @ApiOperation(value = "查询菜单树形数据，用于系统左侧导航",notes = "查询菜单树形数据，用于系统左侧导航")
    @GetMapping(value="/findNavTree")
    public HttpResult findNavTree(@RequestParam String userName) {
        return HttpResult.ok(sysMenuService.findTree(userName, 1));
    }

    @ApiOperation(value = "查询菜单树形数据，用于修改权限",notes = "查询菜单树形数据，用于修改权限")
    @GetMapping("/findMenuTree")
    public HttpResult delete(){
        return HttpResult.ok(sysMenuService.findTree(null,0));
    }
}
