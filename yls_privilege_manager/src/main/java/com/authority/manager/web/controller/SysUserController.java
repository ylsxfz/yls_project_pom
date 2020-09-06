package com.authority.manager.web.controller;

import com.authority.manager.component.security.utils.PasswordUtils;
import com.authority.manager.web.model.SysUser;
import com.authority.manager.web.service.SysUserService;
import com.yls.core.http.HttpConstants;
import com.yls.core.http.HttpResult;
import com.yls.core.page.MyPageRequest;
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
@RequestMapping("sys_user")
@Api(tags = "用户管理接口")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @ApiOperation(value = "保存用户")
    @PostMapping("/save")
    public HttpResult save(@ApiParam(value = "用户对象", required = true)@RequestBody SysUser record){
        Optional optional  = sysUserService.findById(record.getId());

        if (record.getPassword()!=null){
            String salt = PasswordUtils.getSalt();
            System.err.println("判断用户为空："+optional.isPresent());
            if (optional.isPresent()){
                //新增用户
                if(sysUserService.findByName(record.getName()) != null){
                    return HttpResult.error("用户名已存在！");
                }
                String password = PasswordUtils.encode(record.getPassword(), salt);
                record.setSalt(salt);
                record.setPassword(password);
            }else {

                //修改用户
                if(!record.getPassword().equals("")){
                    String password = PasswordUtils.encode(record.getPassword(),salt);
                    record.setSalt(salt);
                    record.setPassword(password);
                }
            }
        }
        sysUserService.save(record);
        return HttpResult.ok(HttpConstants.SAVE_OK);
    }

    @ApiOperation(value = "删除用户")
    @PostMapping("/delete")
    public HttpResult delete(@ApiParam(value = "用户对象集合", required = true)@RequestBody List<SysUser> records){
        sysUserService.deleteAll(records);
        return HttpResult.ok(HttpConstants.DELETE_OK);
    }

    @ApiOperation(value = "根据姓名查询用户")
    @ApiImplicitParam(name = "name",value = "姓名",required = true)
    @GetMapping(value="/findByName")
    public HttpResult findByUserName(@RequestParam String name) {
        return HttpResult.ok(sysUserService.findByName(name));
    }

    @ApiOperation(value = "根据姓名查询用户权限")
    @ApiImplicitParam(name = "name",value = "姓名",required = true)
    @GetMapping(value="/findPermissions")
    public HttpResult findPermissions(String name) {
        return HttpResult.ok(sysUserService.findPermissions(name));
    }


    @ApiOperation(value = "分页查询用户")
    @PostMapping("/findByPage")
    public HttpResult findPage(@ApiParam(value = "封装的分页请求对象", required = true)@RequestBody MyPageRequest myPageRequest){
        PageRequest pageRequest = PageRequest.of(myPageRequest.getPageNum(),myPageRequest.getPageSize());
        Page page = sysUserService.findByPage(pageRequest);
        return HttpResult.ok(page);
    }
}
