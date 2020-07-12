package com.authority.manager.component.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

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
    public ErrorInfo defaultErrorHandler(HttpServletRequest request,Exception e)throws Exception{
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setMessage(e.getMessage());
        errorInfo.setUrl(request.getRequestURI());
        errorInfo.setCode(ErrorInfo.SUCCESS);
        return errorInfo;
    }


//    @ExceptionHandler(MaxUploadSizeExceededException.class)
//    public void uploadException(MaxUploadSizeExceededException e, HttpServletResponse response)throws Exception{
//        response.setContentType("text/html;charset=utf-8");
//        PrintWriter out = response.getWriter();
//        out.write(HttpResult.error("上传文件大小超过限制！").toString());
//        out.flush();
//        out.close();
//    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ModelAndView uploadException(HttpServletRequest request,MaxUploadSizeExceededException e)throws Exception{
       ErrorInfo errorInfo = new ErrorInfo();
       errorInfo.setMessage(e.getMessage());
       errorInfo.setUrl(request.getRequestURI());
       errorInfo.setCode(ErrorInfo.SUCCESS);

       ModelAndView mv = new ModelAndView();
       mv.addObject("error","上传文件大小超过限制！");
       mv.addObject(errorInfo);
       mv.setViewName("error");
       return mv;
    }
}
