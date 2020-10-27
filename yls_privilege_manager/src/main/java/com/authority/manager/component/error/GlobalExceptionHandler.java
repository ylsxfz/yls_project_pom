package com.authority.manager.component.error;

import com.authority.manager.base.http.HttpResponseVO;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

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
public class GlobalExceptionHandler {
    //ExceptionHandler 用来定义函数针对的异常类型，可以传入多个需要捕获的异常。
    @ExceptionHandler(BusinessException.class)
    //如果返回的json数据或者其他对象，添加该注解
    @ResponseBody
    public HttpResponseVO defaultErrorHandler(HttpServletRequest request, BusinessException e)throws Exception{
        return HttpResponseVO.error(e.getErrorCode(),e.getErrorMsg());
    }

    /**
     * 空指针异常
     */
    @ExceptionHandler(NullPointerException.class)
    public HttpResponseVO nullPointerExceptionHandler(NullPointerException e) {
        return HttpResponseVO.error(BaseErrorCommonEnum.BODY_NOT_MATCH);
    }

    /**
     * 类型转换异常
     */
    @ExceptionHandler(ClassCastException.class)
    public HttpResponseVO classCastExceptionHandler(ClassCastException e) {
        return null;
    }


    /**
     * 数组越界异常
     */
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public HttpResponseVO ArrayIndexOutOfBoundsException(ArrayIndexOutOfBoundsException e) {
        return null;
    }

    //IO异常
    @ExceptionHandler(IOException.class)
    public String iOExceptionHandler(IOException ex) {
        return null;
    }

    //未知方法异常
    @ExceptionHandler(NoSuchMethodException.class)
    public String noSuchMethodExceptionHandler(NoSuchMethodException ex) {
        return null;
    }

    //400错误
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public String requestNotReadable(HttpMessageNotReadableException ex) {
       return null;
    }

    //400错误
    @ExceptionHandler({TypeMismatchException.class})
    public String requestTypeMismatch(TypeMismatchException ex) {
        return null;
    }

    //400错误
    @ExceptionHandler({MissingServletRequestParameterException.class})
    public String requestMissingServletRequest(MissingServletRequestParameterException ex) {
        System.out.println("400..MissingServletRequest");
        return null;
    }


    //405错误
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public String request405(HttpRequestMethodNotSupportedException ex) {
        return null;
    }

    //406错误
    @ExceptionHandler({HttpMediaTypeNotAcceptableException.class})
    public String request406(HttpMediaTypeNotAcceptableException ex) {
        System.out.println("406...");
        return null;
    }

    //500错误
    @ExceptionHandler({ConversionNotSupportedException.class, HttpMessageNotWritableException.class})
    public String server500(RuntimeException ex) {
        System.out.println("500...");
        return null;
    }


    //栈溢出
    @ExceptionHandler({StackOverflowError.class})
    public String requestStackOverflow(StackOverflowError ex) {
        return null;
    }


    //除数不能为0
    @ExceptionHandler({ArithmeticException.class})
    public String arithmeticException(ArithmeticException ex) {
        return null;
    }


    /**
     * 其他错误
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public HttpResponseVO errorHandler(Exception ex) {
        ex.printStackTrace();
        return HttpResponseVO.error(BaseErrorCommonEnum.BODY_NOT_MATCH);
    }

    @ResponseBody
    @ExceptionHandler(value = AccessDeniedException.class)
    public HttpResponseVO errorHandler(AccessDeniedException ex) {
        ex.printStackTrace();
        return HttpResponseVO.error(BaseErrorCommonEnum.BODY_NOT_MATCH);
    }


    /**
     * 文件上传超出大小异常
     */
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public HttpResponseVO uploadException(HttpServletRequest request,MaxUploadSizeExceededException e)throws Exception{
       return null;
    }

    //    @ExceptionHandler(MaxUploadSizeExceededException.class)
//    public void uploadException(MaxUploadSizeExceededException e, HttpServletResponse response)throws Exception{
//        response.setContentType("text/html;charset=utf-8");
//        PrintWriter out = response.getWriter();
//        out.write(HttpResult.error("上传文件大小超过限制！").toString());
//        out.flush();
//        out.close();
//    }
}
