package com.authority.manager.web.controller;

import com.authority.manager.contant.SysContants;

import com.authority.manager.web.model.SysRole;
import com.authority.manager.web.model.SysRoleMenu;
import com.authority.manager.web.service.impl.SysRoleServiceImpl;
import com.yls.common.utils.StringFormatUtils;
import com.yls.core.http.HttpConstants;
import com.yls.core.http.HttpResult;
import com.yls.core.page.MyPageRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @Author yls
 * @Date 2020/4/5 12:21
 * @Description 权限管理控制器
 * @Version 1.0
 **/
@RestController
@RequestMapping("sys_role")
@Api(tags = "权限管理接口")
public class SysRoleController {

    @Autowired
    private SysRoleServiceImpl sysRoleSerivce;

    @ApiOperation(value = "保存权限",notes = "保存权限")
    @PostMapping("/save")
    public HttpResult save(@RequestBody SysRole record){

        SysRole sysRole = sysRoleSerivce.findByName(record.getName());
        if (sysRole!=null){
            //新增用户
            if (StringFormatUtils.isNull(record.getId()) || "0".equals(record.getId())){
                return  HttpResult.error("角色名已存在！");
            }

            //如果是修改用户角色名
            else if (!sysRole.getId().equals(record.getId())){
                return  HttpResult.error("角色名已存在！");
            }
        }
        sysRoleSerivce.save(record);
        return HttpResult.ok(HttpConstants.SAVE_OK);
    }

    @ApiOperation(value = "删除权限",notes = "删除权限")
    @PostMapping("/delete")
    public HttpResult delete(@RequestBody List<SysRole> records){
        sysRoleSerivce.deleteAll(records);
        return HttpResult.ok(HttpConstants.DELETE_OK);
    }

    @ApiOperation(value = "分页查询权限",notes = "分页查询权限")
    @PostMapping("/findByPage")
    public HttpResult findPage(@RequestBody MyPageRequest myPageRequest){
        PageRequest pageRequest = PageRequest.of(myPageRequest.getPageNum(), myPageRequest.getPageSize());
        Page page = sysRoleSerivce.findByPage(pageRequest);
        return HttpResult.ok(page);
    }

    @ApiOperation(value = "查询所有权限",notes = "查询所有权限")
    @GetMapping(value="/findAll")
    public HttpResult findAll()  {
        try {
            return HttpResult.ok(sysRoleSerivce.findAll());
        }catch (Exception e){
            return HttpResult.error("查询失败！"+e.getMessage());
        }
    }

    @ApiOperation(value = "根据权限id查询菜单",notes = "根据权限id查询菜单")
    @GetMapping(value="/findRoleMenus")
    public HttpResult findRoleMenus(@RequestParam String roleId) {
        return HttpResult.ok(sysRoleSerivce.findRoleMenus(roleId));
    }

    @ApiOperation(value = "根据权限修改菜单权限",notes = "根据权限修改菜单权限")
    @PostMapping(value = "/saveRoleMenus")
    public HttpResult saveRoleMenus(@RequestBody List<SysRoleMenu> records){
        if (records!=null && !records.isEmpty()){
            SysRoleMenu sysRoleMenu = records.get(0);
            Optional optional = sysRoleSerivce.findById(sysRoleMenu.getRoleId());
            if (optional.isPresent()){
                SysRole sysRole = (SysRole) optional.get();
                if (SysContants.ADMIN.equals(sysRole.getName())){
                    return HttpResult.error("超级管理员拥有所有菜单权限，不允许修改！");
                }else {
                    sysRoleSerivce.saveRoleMenus(records);
                }
            }
        }
        return  HttpResult.ok("保存成功!");
    }
}
