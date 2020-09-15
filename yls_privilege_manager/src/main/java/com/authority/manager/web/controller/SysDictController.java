package com.authority.manager.web.controller;


import com.authority.manager.web.model.SysDictDO;
import com.authority.manager.web.service.SysDictService;
import com.yls.core.http.HttpConstants;
import com.yls.core.http.HttpResultVO;
import com.yls.core.page.MyPageQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author yls
 * @Date 2020/4/5 12:21
 * @Description 字典管理控制器
 * @Version 1.0
 **/
@RestController
@RequestMapping("sys")
@Api(tags = "字典管理接口")
public class SysDictController {

    @Autowired
    private SysDictService sysDictService;

    @ApiOperation(value = "保存字典管理")
    @PostMapping("dict")
    public HttpResultVO save(@ApiParam(value = "字典对象", required = true)@RequestBody SysDictDO record){
        sysDictService.save(record);
        return HttpResultVO.ok(HttpConstants.SAVE_OK);
    }


    @ApiOperation(value = "删除字典记录")
    @DeleteMapping("dict")
    public HttpResultVO delete(@ApiParam(value = "字典对象集合", required = true)@RequestBody List<SysDictDO> records){
        sysDictService.deleteAll(records);
        return HttpResultVO.ok(HttpConstants.DELETE_OK);
    }

    @ApiOperation(value = "分页查询字典记录")
    @PostMapping("dict/lists")
    public HttpResultVO lists(@ApiParam(value = "封装的分页请求对象", required = true)@RequestBody MyPageQuery myPageQuery){
        PageRequest pageRequest = PageRequest.of(myPageQuery.getPageNum(), myPageQuery.getPageSize());
        Page page = sysDictService.findByPage(pageRequest);
        return HttpResultVO.ok(page);
    }
}
