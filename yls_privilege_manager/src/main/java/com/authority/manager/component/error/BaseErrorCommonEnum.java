package com.authority.manager.component.error;

/**
 * @Auther: yls
 * @Date: 2020/10/20 10:29
 * @Description: 自定义一个异常信息枚举类
 * @Version 1.0
 */
public enum BaseErrorCommonEnum implements BaseErrorInfoInterface {
    // 数据操作错误定义
    SUCCESS(200, "成功！"),
    BODY_NOT_MATCH(400, "请求的数据格式不符！"),
    SIGNATURE_NOT_MATCH(401, "请求的数字签名不匹配！"),
    NOT_FOUND(404, "未找到该资源！"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误！"),

    DEFAULT_ERROR(1000, "其他错误！"),
    NULL_POINTER_ERROR(1001, "空指针异常！"),
    CLASS_CAST_ERROR(1002, "类型转换异常！"),
    ARRAY_INDEX_OUT_OF_BOUNDS(1003, "数组越界异常！"),
    IO_ERR0R(1004, "IO异常！"),
    NO_SUCH_METHOD_ERROR(1005, "未知方法异常！"),
    REQUEST_NOT_READABLE(1006, "400错误：Http消息不可读异常！"),
    REQUEST_TYPE_MISMATCH(1007, "400错误：类型不匹配异常！"),
    REQUEST_MISSING_SERVLET(1008, "400错误：请求参数异常！"),
    REQUEST_METHOD_NOT_SUPPORTED(1009, "405异常：Http请求方法不支持异常！"),
    REQUEST_MEDIA_TYPE_NOT_ACCEPTABLE(1010, "406异常：Http媒体类型不可接受异常" ),
    REQUEST_STACK_OVER_FLOW(1011, "栈溢出！"),
    ARITMETIC_ERROR(1012, "除数不能为0！"),
    UPLOAD_MAX_SIZE_ERROR(1013,"文件上传超过最大限制！"),
    ACCESS_DENIED_ERROR(1014,"没有权限！"),
    SERVER_BUSY(503, "服务器正忙，请稍后再试！");


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
