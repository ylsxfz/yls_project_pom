package com.authority.manager.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author yls
 * @Date 2020/3/30 21:19
 * @Description 需要在容器启动的时候执行一些内容。比如读取配置文件，
 *          数据库连接之类的。SpringBoot给我们提供了两个接口来帮助我们实现这种需求。
 *          这两个接口分别为CommandLineRunner和ApplicationRunner。
 *          他们执行时机为容器启动完成的时候。
 *          Order：执行顺序，值越小越先执行
 * @Version 1.0
 **/
@Component
@Order(1)
public class MyCommandLineRunner implements CommandLineRunner {
    /**
     * 功能描述:
     * 〈web业务系统初始化的主要方法〉
     * @author : yls
     * @date : 2020/07/12 10:54
     * @param args app的参数
     * @return : void
     */
    @Override
    public void run(String... args) throws Exception {
        //获取项目启动携带的参数
        //System.out.println("runner=》"+ Arrays.toString(args));
    }
}
