package com.authority.manager.error;

/**
 * @Author yls
 * @Date 2020/3/30 14:37
 * @Description 统一封装自定义业务异常
 * @Version 1.0
 **/
public class BusinessException extends RuntimeException{

    public BusinessException() {

    }

    public BusinessException(String message) {
        super(message);
    }
}
