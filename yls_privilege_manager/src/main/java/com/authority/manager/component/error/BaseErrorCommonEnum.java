package com.authority.manager.component.error;

/**
 * @Auther: yls
 * @Date: 2020/10/20 10:29
 * @Description: 自定义一个异常信息枚举类
 * @Version 1.0
 */
public enum  BaseErrorCommonEnum implements BaseErrorInfoInterface {
    // 数据操作错误定义
    SUCCESS(200, "成功!"),
    BODY_NOT_MATCH(400, "请求的数据格式不符!"),
    SIGNATURE_NOT_MATCH(401, "请求的数字签名不匹配!"),
    NOT_FOUND(404, "未找到该资源!"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误!"),
    SERVER_BUSY(503, "服务器正忙，请稍后再试!");

    /**
     * 返回状态
     */
    private Integer errorCode;

    /**
     * 返回信息
     */
    private String errorMsg;

    BaseErrorCommonEnum(Integer errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    @Override
    public Integer getErrorCode() {
        return errorCode;
    }

    @Override
    public String getErrorMsg() {
        return errorMsg;
    }
}
