package com.authority.manager.web.controller;

import com.authority.manager.contant.SysContants;
import com.authority.manager.web.model.SysMenuDO;
import com.authority.manager.web.service.SysMenuService;
import com.yls.core.http.HttpConstants;
import com.yls.core.http.HttpResponseVO;
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
@RequestMapping("sys")
@Api(tags = "菜单管理接口")
public class SysMenuController {
    @Autowired
    private SysMenuService sysMenuService;

    @ApiOperation(value = "保存菜单记录")
    @PostMapping("menu")
    public HttpResponseVO save(@ApiParam(value = "菜单对象", required = true)@RequestBody SysMenuDO record){
        sysMenuService.save(record);
        return HttpResponseVO.ok(HttpConstants.SAVE_OK);
    }


    @ApiOperation(value = "删除菜单记录")
    @DeleteMapping("menu")
    public HttpResponseVO delete(@ApiParam(value = "菜单对象集合", required = true)@RequestBody List<SysMenuDO> records){
        sysMenuService.deleteAll(records);
        return HttpResponseVO.ok(HttpConstants.DELETE_OK);
    }


    @ApiOperation(value = "查询左侧导航")
    @ApiImplicitParam(name = "userName",value = "用户名",required = true)
    @GetMapping(value="menu/{username}")
    public HttpResponseVO getNavTree(@PathVariable("username") String userName) {
        return HttpResponseVO.ok(sysMenuService.findTree(userName, SysContants.SEARCH_MENU));
    }

    @ApiOperation(value = "查询菜单数据")
    @GetMapping("menu")
    public HttpResponseVO findMenuTree(){
        return HttpResponseVO.ok(sysMenuService.findTree(null,SysContants.SEARCH_MENU_AND_BUTTON));
    }
}
