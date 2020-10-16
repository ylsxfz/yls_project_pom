package com.authority.manager.datamodel.pattern.numberexpansion;

import com.authority.manager.contant.BusinessConstant;
import com.authority.manager.datamodel.pattern.ProcessModelHandler;

/**
 * @Auther: yls
 * @Date: 2020/09/21 15:31
 * @Description:  职责链模式结构：号码拓展抽象处理者
 * @Version 1.0
 */
public abstract class NumberExpansionModelHandler extends ProcessModelHandler {
    public NumberExpansionModelHandler(String name) {
        super(BusinessConstant.DATA_REPAIR+"==》" +name);
    }
}