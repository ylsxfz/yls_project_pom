package com.authority.manager.web.controller;

import com.authority.manager.contant.SysContants;
import com.authority.manager.web.model.SysRoleDO;
import com.authority.manager.web.model.relation.SysRoleMenuDO;
import com.authority.manager.web.service.impl.SysRoleServiceImpl;
import com.yls.core.http.HttpConstants;
import com.yls.core.http.HttpResultVO;
import com.yls.core.page.MyPageQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@RequestMapping("sys")
@Api(tags = "角色权限管理接口")
public class SysRoleController {

    @Autowired
    private SysRoleServiceImpl sysRoleSerivce;

    @ApiOperation(value = "保存角色")
    @PostMapping("role")
    public HttpResultVO save(@ApiParam(value = "角色对象", required = true)@RequestBody SysRoleDO record){

        SysRoleDO sysRoleDO = sysRoleSerivce.findByName(record.getName());
        if (sysRoleDO !=null){
            //新增用户
            if (record.getId()==0){
                return  HttpResultVO.error("角色名已存在！");
            }

            //如果是修改用户角色名
            else if (sysRoleDO.getId()!=record.getId()){
                return  HttpResultVO.error("角色名已存在！");
            }
        }
        sysRoleSerivce.save(record);
        return HttpResultVO.ok(HttpConstants.SAVE_OK);
    }

    @ApiOperation(value = "删除权限")
    @DeleteMapping("role")
    public HttpResultVO delete(@ApiParam(value = "角色对象集合", required = true)@RequestBody List<SysRoleDO> records){
        sysRoleSerivce.deleteAll(records);
        return HttpResultVO.ok(HttpConstants.DELETE_OK);
    }

    @ApiOperation(value = "分页查询权限")
    @PostMapping("role/lists")
    public HttpResultVO findPage(@ApiParam(value = "封装的分页请求对象", required = true)@RequestBody MyPageQuery myPageQuery){
        PageRequest pageRequest = PageRequest.of(myPageQuery.getPageNum(), myPageQuery.getPageSize());
        Page page = sysRoleSerivce.findByPage(pageRequest);
        return HttpResultVO.ok(page);
    }

    @ApiOperation(value = "查询所有权限")
    @GetMapping(value="role/all")
    public HttpResultVO findAll()  {
        try {
            return HttpResultVO.ok(sysRoleSerivce.findAll());
        }catch (Exception e){
            return HttpResultVO.error("查询失败！"+e.getMessage());
        }
    }

    @ApiOperation(value = "查询菜单")
    @ApiImplicitParam(name = "roleId",value = "角色id",dataType = "int",required = true)
    @GetMapping(value="role/{roleId}")
    public HttpResultVO findRoleMenus(@PathVariable("roleId") Integer roleId) {
        return HttpResultVO.ok(sysRoleSerivce.findRoleMenus(roleId));
    }

    @ApiOperation(value = "修改菜单权限")
    @PutMapping(value = "role")
    public HttpResultVO saveRoleMenus(@ApiParam(value = "角色对象集合", required = true)@RequestBody List<SysRoleMenuDO> records){
        if (records!=null && !records.isEmpty()){
            SysRoleMenuDO sysRoleMenuDO = records.get(0);
            Optional optional = sysRoleSerivce.findById(sysRoleMenuDO.getRoleId());
            if (optional.isPresent()){
                SysRoleDO sysRoleDO = (SysRoleDO) optional.get();
                if (SysContants.ADMIN.equals(sysRoleDO.getName())){
                    return HttpResultVO.error("超级管理员拥有所有菜单权限，不允许修改！");
                }else {
                    sysRoleSerivce.saveRoleMenus(records);
                }
            }
        }
        return  HttpResultVO.ok("保存成功!");
    }
}
