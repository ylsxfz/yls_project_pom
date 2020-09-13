package com.authority.manager.functions.controller;


import io.swagger.annotations.Api;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Auther: yls
 * @Date: 2020/09/13 14:32
 * @Description:
 * @Version 1.0
 */
@RestController
@RequestMapping("/batch")
@Api(tags = "批处理测试")
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
}
