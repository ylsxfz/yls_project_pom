package com.authority.manager.web.controller;

import com.authority.manager.component.security.utils.PasswordUtils;
import com.authority.manager.web.model.SysUserDO;
import com.authority.manager.web.service.SysUserJpaService;
import com.yls.core.http.HttpConstants;
import com.authority.manager.component.http.HttpResponseVO;
import com.yls.core.page.PageRequstQuery;
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
 * @Description 用户管理控制器
 * @Version 1.0
 **/
@RestController
@RequestMapping("sys")
@Api(tags = "用户管理接口")
public class SysUserController {
    @Autowired
    private SysUserJpaService sysUserService;

    @ApiOperation(value = "查询用户权限",notes = "根据姓名查询用户权限")
    @ApiImplicitParam(name = "name",value = "姓名",required = true)
    @GetMapping(value="user/permissions/{userName}")
    public HttpResponseVO listSysUserPermissions(@PathVariable("userName") String userName) {
        return HttpResponseVO.ok(sysUserService.findPermissions(userName));
    }

    @ApiOperation(value = "查询用户",notes = "根据姓名查询用户")
    @ApiImplicitParam(name = "name",value = "姓名",required = true)
    @GetMapping(value="user/{name}")
    public HttpResponseVO getSysUserByUserName(@PathVariable("name")  String name) {
        return HttpResponseVO.ok(sysUserService.findByName(name));
    }


    @ApiOperation(value = "保存用户")
    @PostMapping("user")
    public HttpResponseVO saveSysUser(@ApiParam(value = "用户对象", required = true)@RequestBody SysUserDO record){
        Optional optional  = sysUserService.findById(record.getId());
        if (record.getPassword()!=null){
            String salt = PasswordUtils.getSalt();
            System.err.println("判断用户为空："+optional.isPresent());
            if (!optional.isPresent()){
                //新增用户
                if(sysUserService.findByName(record.getName()) != null){
                    return HttpResponseVO.error("用户名已存在！");
                }
                String password = PasswordUtils.encode(record.getPassword(), salt);
                record.setSalt(salt);
                record.setPassword(password);
            }
        }
        sysUserService.saveUser(record);
        return HttpResponseVO.ok(HttpConstants.SAVE_OK);
    }


    @ApiOperation(value = "修改用户")
    @PutMapping("user")
    public HttpResponseVO updateSysUser(@ApiParam(value = "用户对象", required = true)@RequestBody SysUserDO record){
        Optional optional  = sysUserService.findById(record.getId());
        if (record.getPassword()!=null){
            String salt = PasswordUtils.getSalt();
            //System.err.println("判断用户为空："+optional.isPresent());
            if (optional.isPresent()){
                //修改用户
                if(!record.getPassword().equals("")){
                    String password = PasswordUtils.encode(record.getPassword(),salt);
                    record.setSalt(salt);
                    record.setPassword(password);
                }
            }
        }
        sysUserService.save(record);
        return HttpResponseVO.ok(HttpConstants.SAVE_OK);
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping("user/{id}")
    public HttpResponseVO deleteSysUserById(@ApiParam(value = "用户id", required = true)@PathVariable("id") String id){
        sysUserService.deleteById(id);
        return HttpResponseVO.ok(HttpConstants.DELETE_OK);
    }


    @ApiOperation(value = "批量删除用户")
    @DeleteMapping("user")
    public HttpResponseVO deleteSysUserByIdS(@ApiParam(value = "用户对象集合", required = true)@RequestBody List<SysUserDO> records){
        sysUserService.deleteAll(records);
        return HttpResponseVO.ok(HttpConstants.DELETE_OK);
    }


    @ApiOperation(value = "分页查询用户")
    @PostMapping("user/lists")
    public HttpResponseVO lists(@ApiParam(value = "封装的分页请求对象", required = true)@RequestBody PageRequstQuery pageRequstQuery){
        PageRequest pageRequest = PageRequest.of(pageRequstQuery.getPageNum(), pageRequstQuery.getPageSize());
        Page page = sysUserService.findByPage(pageRequest);
        return HttpResponseVO.ok(page);
    }






}
