package com.authority.manager.datamodel.controller;

import com.authority.manager.datamodel.model.ProcessDataDTO;
import com.authority.manager.datamodel.pattern.ProcessModelHandler;
import com.authority.manager.datamodel.pattern.DataRepairHandler;
import com.authority.manager.datamodel.pattern.NumberCheckHandler;
import com.authority.manager.datamodel.pattern.NumberExpansionHandler;

/**
 * @Auther: yls
 * @Date: 2020/09/21 12:02
 * @Description: 职责链模式-主程序，控制整个流程
 * @Version 1.0
 */
public class ChainOfResPatternController {
    public static void main(String[] args) {
        /**
         * 1、初始化数据
         */
        ProcessDataDTO processDataDTO = new ProcessDataDTO();

        /**
         * 2、初始化职责链的相关对象
         */
        ProcessModelHandler dataRepairHandler,numberCheckHandler,numberExpansionHandler;
        dataRepairHandler = new DataRepairHandler("数据修复");
        numberCheckHandler = new NumberCheckHandler("数据核对");
        numberExpansionHandler = new NumberExpansionHandler("号码拓展");

        /**
         * 3、创建职责链
         */
        dataRepairHandler.setNextProcessHandler(numberCheckHandler);
        numberCheckHandler.setNextProcessHandler(numberExpansionHandler);

        /**
         * 4、执行流程
         */
        dataRepairHandler.processRequest(processDataDTO);

    }
}
