package com.authority.manager.datamodel.pattern;

import com.authority.manager.datamodel.model.ProcessDataDTO;

/**
 * @Auther: yls
 * @Date: 2020/09/21 11:38
 * @Description: 职责链模式结构：抽象处理者
 * @Version 1.0
 */
public abstract class ProcessModelHandler {
    /**
     * 定义后继对象
     */
    protected ProcessModelHandler nextProcessHandler;

    /**
     * 节点名称
     */
    protected  String name;

    public ProcessModelHandler(String name){
        this.name = name;
    }

    /**
     * 设置后继者
     */
    public void setNextProcessHandler(ProcessModelHandler nextProcessHandler) {
        this.nextProcessHandler = nextProcessHandler;
    }

    /**
     * 功能描述:
     * 〈抽象请求处理方法〉
     * @author : yls
     * @date : 2020/09/21 11:44
     * @param processDataDTO 请求相关的数据和参数
     * @return : void
     */
    public abstract void processRequest(ProcessDataDTO processDataDTO);
}
