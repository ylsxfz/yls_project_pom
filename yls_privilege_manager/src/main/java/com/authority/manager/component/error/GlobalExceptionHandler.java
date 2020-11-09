package com.authority.manager.component.error;

import com.authority.manager.base.http.HttpResponseVO;
import org.apache.commons.math3.exception.ZeroException;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.annotation.Priority;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author yls
 * @Date 2020/3/30 14:39
 * @Description 统一封装业务的异常处理
 * @Version 1.0
 **/
//ControllerAdvice：该注解是定义统一的异常处理，
//basePackages：定义扫描哪些包(basePackages = "com.authority.manager")

@ControllerAdvice
@Priority(1)
public class GlobalExceptionHandler {
//    //ExceptionHandler 用来定义函数针对的异常类型，可以传入多个需要捕获的异常。
//    @ExceptionHandler(BusinessException.class)
//    //如果返回的json数据或者其他对象，添加该注解
//    @ResponseBody
//    public HttpResponseVO defaultErrorHandler(HttpServletRequest request, BusinessException e)throws Exception{
//        return HttpResponseVO.error(e.getErrorCode(),e.getErrorMsg());
//    }

    /**
     * 空指针异常
     */
    @ResponseBody
    @ExceptionHandler(NullPointerException.class)
    public HttpResponseVO nullPointerExceptionHandler(NullPointerException e) {
        return HttpResponseVO.error(BaseErrorCommonEnum.NULL_POINTER_ERROR);
    }

    /**
     * 类型转换异常
     */
    @ResponseBody
    @ExceptionHandler(ClassCastException.class)
    public HttpResponseVO classCastExceptionHandler(ClassCastException e) {
        return HttpResponseVO.error(BaseErrorCommonEnum.CLASS_CAST_ERROR);
    }


    /**
     * 数组越界异常
     */
    @ResponseBody
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public HttpResponseVO ArrayIndexOutOfBoundsException(ArrayIndexOutOfBoundsException e) {
        return HttpResponseVO.error(BaseErrorCommonEnum.ARRAY_INDEX_OUT_OF_BOUNDS);
    }

    /**
     * IO异常
     */
    @ResponseBody
    @ExceptionHandler(IOException.class)
    public HttpResponseVO iOExceptionHandler(IOException ex) {
        return HttpResponseVO.error(BaseErrorCommonEnum.IO_ERR0R);
    }

    /**
     * 未知方法异常
     */
    @ResponseBody
    @ExceptionHandler(NoSuchMethodException.class)
    public HttpResponseVO noSuchMethodExceptionHandler(NoSuchMethodException ex) {
        return HttpResponseVO.error(BaseErrorCommonEnum.NO_SUCH_METHOD_ERROR);
    }

    /**
     * 400错误
     */
    @ResponseBody
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public HttpResponseVO requestNotReadable(HttpMessageNotReadableException ex) {
       return HttpResponseVO.error(BaseErrorCommonEnum.REQUEST_NOT_READABLE);
    }

    /**
     * 400错误
     */
    @ResponseBody
    @ExceptionHandler({TypeMismatchException.class})
    public HttpResponseVO requestTypeMismatch(TypeMismatchException ex) {
        return HttpResponseVO.error(BaseErrorCommonEnum.REQUEST_TYPE_MISMATCH);
    }

    /**
     * 400错误
     */
    @ResponseBody
    @ExceptionHandler({MissingServletRequestParameterException.class})
    public HttpResponseVO requestMissingServletRequest(MissingServletRequestParameterException ex) {
        return HttpResponseVO.error(BaseErrorCommonEnum.REQUEST_MISSING_SERVLET);
    }


    /**
     * 405错误
     */
    @ResponseBody
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public HttpResponseVO requestMethodNotSupported(HttpRequestMethodNotSupportedException ex) {
        return HttpResponseVO.error(BaseErrorCommonEnum.REQUEST_METHOD_NOT_SUPPORTED);
    }

    /**
     * 406错误
     */
    @ResponseBody
    @ExceptionHandler({HttpMediaTypeNotAcceptableException.class})
    public HttpResponseVO requestMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex) {
        return HttpResponseVO.error(BaseErrorCommonEnum.REQUEST_MEDIA_TYPE_NOT_ACCEPTABLE);
    }

    /**
     * 500错误
     */
    @ResponseBody
    @ExceptionHandler({ConversionNotSupportedException.class, HttpMessageNotWritableException.class})
    public HttpResponseVO conversionNotSupported(RuntimeException ex) {
        return HttpResponseVO.error(BaseErrorCommonEnum.INTERNAL_SERVER_ERROR);
    }


    /**
     * 栈溢出
     */
    @ResponseBody
    @ExceptionHandler({StackOverflowError.class})
    public HttpResponseVO requestStackOverflow(StackOverflowError ex) {
        return HttpResponseVO.error(BaseErrorCommonEnum.REQUEST_STACK_OVER_FLOW);
    }


    /**
     * 除数不能为0
     */
    @ResponseBody
    @ExceptionHandler({ArithmeticException.class,ZeroException.class})
    public HttpResponseVO arithmeticException(ArithmeticException ex) {
        return HttpResponseVO.error(BaseErrorCommonEnum.ARITMETIC_ERROR);
    }


//    /**
//     * 其他错误
//     */
//    @ResponseBody
//    @ExceptionHandler(value = Exception.class)
//    public HttpResponseVO errorHandler(Exception ex) {
//        ex.printStackTrace();
//        return HttpResponseVO.error(BaseErrorCommonEnum.DEFAULT_ERROR);
//    }


    /**
     * 没有权限操作
     */
    @ResponseBody
    @ExceptionHandler(value = AccessDeniedException.class)
    public HttpResponseVO accessDeniedHandler(AccessDeniedException ex) {
        return HttpResponseVO.error(BaseErrorCommonEnum.ACCESS_DENIED_ERROR);
    }


    /**
     * 文件上传超出大小异常
     */
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public HttpResponseVO uploadMaxUploadSizeException(HttpServletRequest request,MaxUploadSizeExceededException e)throws Exception{
       return HttpResponseVO.error(BaseErrorCommonEnum.UPLOAD_MAX_SIZE_ERROR);
    }


}
