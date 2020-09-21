package com.authority.manager.datamodel.pattern;

import com.authority.manager.datamodel.model.ProcessDataDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Auther: yls
 * @Date: 2020/09/21 11:52
 * @Description: 职责链模式结构：具体处理者-号码核对
 * @Version 1.0
 */
public class NumberCheckHandler extends ProcessModelHandler {

    private static  final Logger LOGGER = LoggerFactory.getLogger(NumberCheckHandler.class);

    public NumberCheckHandler(String name) {
        super(name);
    }

    @Override
    public void processRequest(ProcessDataDTO processDataDTO) {
        if (this.nextProcessHandler==null){
            return;
        }
        System.out.println("本次流程："+this.name+"==》开始执行");
        try {
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
        processDataDTO.setNodeName(this.name);
        System.err.println(processDataDTO);
        System.out.println("本次流程："+this.name+"==》执行结束，共计耗时");
        this.nextProcessHandler.processRequest(processDataDTO);
    }
}
