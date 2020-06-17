package com.authority.manager.init;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author yls
 * @Date 2020/3/30 21:23
 * @Description
 * @Version 1.0
 **/
@Component
@Order(1)
public class MyApplicationRunner implements ApplicationRunner {
    /**
     * Callback used to run the bean.
     *
     * @param args incoming application arguments
     * @throws Exception on error
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        //获取项目启动携带的参数
//        List<String> nonOptionArgs = args.getNonOptionArgs();
//        System.out.println("nonOptionArgs=》"+nonOptionArgs);
//        Set<String> optionNames = args.getOptionNames();
//        optionNames.forEach(val->{
//            System.out.println("key:"+val+",value:"+args.getOptionValues(val));
//        });
    }
}
