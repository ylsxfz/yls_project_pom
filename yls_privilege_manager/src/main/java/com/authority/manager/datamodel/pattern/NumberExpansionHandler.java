package com.authority.manager.datamodel.pattern;

import com.authority.manager.datamodel.model.ProcessDataDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Auther: yls
 * @Date: 2020/09/21 11:52
 * @Description: 职责链模式结构：具体处理者-号码拓展
 * @Version 1.0
 */
public class NumberExpansionHandler extends ProcessModelHandler {

    private static  final Logger LOGGER = LoggerFactory.getLogger(NumberExpansionHandler.class);

    public NumberExpansionHandler(String name) {
        super(name);
    }

    @Override
    public void processRequest(ProcessDataDTO processDataDTO) {
        System.out.println("本次流程："+this.name+"==》开始执行");
        try {
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
        processDataDTO.setNodeName(this.name);
        System.err.println(processDataDTO);
        System.out.println("本次流程："+this.name+"==》执行结束，共计耗时");
        if (this.nextProcessHandler==null){
            return;
        }
        this.nextProcessHandler.processRequest(processDataDTO);
    }
}
