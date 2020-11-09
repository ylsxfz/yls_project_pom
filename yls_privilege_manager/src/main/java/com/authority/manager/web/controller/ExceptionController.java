package com.authority.manager.web.controller;

import com.authority.manager.base.http.HttpResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: yls
 * @Date: 2020/11/9 14:34
 * @Description: 测试全局异常拦截
 * @Version 1.0
 */
@RestController
@RequestMapping("sys")
@Api(tags = "测试全局异常")
public class ExceptionController {

    @ApiOperation(value = "除数为0")
    @GetMapping(value = "/zero")
    @ResponseBody
    public HttpResponseVO zeroException() throws Exception{
        int a = 5 / 0;
        return HttpResponseVO.ok();
    }

    @PreAuthorize("hasAuthority('except:dict:delete')")
    @ApiOperation(value = "没有权限")
    @GetMapping(value = "/accessDenied")
    @ResponseBody
    public HttpResponseVO accessDeniedException() throws Exception {
        return HttpResponseVO.ok();
    }


    @ApiOperation(value = "下标越界")
    @GetMapping(value = "/arrayIndexOutOfBounds")
    @ResponseBody
    public HttpResponseVO arrayIndexOutOfBounds()throws Exception {
        int arr[] = {0,1,2};
        int a = arr[10];
        return HttpResponseVO.ok();
    }

}
