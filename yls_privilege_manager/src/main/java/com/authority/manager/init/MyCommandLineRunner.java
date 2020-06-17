package com.authority.manager.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author yls
 * @Date 2020/3/30 21:19
 * @Description 启动系统任务
 *          Order：执行顺序，值越小越先执行
 * @Version 1.0
 **/
@Component
@Order(1)
public class MyCommandLineRunner implements CommandLineRunner {
    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {
        //获取项目启动携带的参数
        //System.out.println("runner=》"+ Arrays.toString(args));
    }
}
