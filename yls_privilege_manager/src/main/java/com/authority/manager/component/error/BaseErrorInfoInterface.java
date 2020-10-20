package com.authority.manager.component.error;
/**
 * @Author yls
 * @Date 2020/3/30 14:28
 * @Description 基础的接口类，自定义的错误描述枚举类需实现该接口。
 * @Version 1.0
 **/
public interface BaseErrorInfoInterface {
    /**
     * 错误码
     */
    Integer getErrorCode();

    /**
     * 错误描述
     */
    String getErrorMsg();
}
