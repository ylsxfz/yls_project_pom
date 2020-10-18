package com.authority.manager.web.controller;


import com.authority.manager.web.model.SysDictDO;
import com.authority.manager.web.service.SysDictJpaService;
import com.yls.core.http.HttpConstants;
import com.yls.core.http.HttpResponseVO;
import com.yls.core.page.PageRequstQuery;
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
    private SysDictJpaService sysDictService;

    @ApiOperation(value = "保存字典管理")
    @PostMapping("dict")
    public HttpResponseVO save(@ApiParam(value = "字典对象", required = true)@RequestBody SysDictDO record){
        sysDictService.save(record);
        return HttpResponseVO.ok(HttpConstants.SAVE_OK);
    }


    @ApiOperation(value = "删除字典记录")
    @DeleteMapping("dict")
    public HttpResponseVO delete(@ApiParam(value = "字典对象集合", required = true)@RequestBody List<SysDictDO> records){
        sysDictService.deleteAll(records);
        return HttpResponseVO.ok(HttpConstants.DELETE_OK);
    }

    @ApiOperation(value = "分页查询字典记录")
    @PostMapping("dict/lists")
    public HttpResponseVO lists(@ApiParam(value = "封装的分页请求对象", required = true)@RequestBody PageRequstQuery pageRequstQuery){
        PageRequest pageRequest = PageRequest.of(pageRequstQuery.getPageNum(), pageRequstQuery.getPageSize());
        Page page = sysDictService.findByPage(pageRequest);
        return HttpResponseVO.ok(page);
    }
}
