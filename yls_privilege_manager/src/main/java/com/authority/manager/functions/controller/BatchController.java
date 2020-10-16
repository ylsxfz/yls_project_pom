package com.authority.manager.functions.controller;


import com.authority.manager.functions.model.SysTestUser;
import io.swagger.annotations.Api;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: yls
 * @Date: 2020/09/13 14:32
 * @Description:
 * @Version 1.0
 */
@RestController
@RequestMapping("/batch")
@Api(tags = "批处理测试和数据校验")
public class BatchController {
    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;

    @GetMapping("/testBatch")
    public void testBatch(){
        try {
            //参数相同的job里面的step默认都只执行一次，加上addDate这个配置是最简单的解决方法。
            JobParameters jobParameters = new JobParametersBuilder().addDate("date", new Date()).toJobParameters();
            jobLauncher.run(job,jobParameters);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Validated: 表示需要对该参数做检验，紧接着BindingResult参数表示在校验出错时保存的出错信息
     * 如果BindingResult中的hasErrors方法返回true，表示有错误信息，此时遍历错误信息，将返回给前端
     * @param sysTestUser 用户
     * @param result 校验结果
     * @return
     */
    @PostMapping("/user")
    public List<String> addUser(@Validated SysTestUser sysTestUser, BindingResult result){
        List<String> errors = new ArrayList<>();
        if(result.hasErrors()){
            List<ObjectError> allErrors = result.getAllErrors();
            allErrors.forEach(objectError -> {
                System.err.println(objectError.getDefaultMessage());
                errors.add(objectError.getDefaultMessage());
            });
        }
        return errors;
    }
}
