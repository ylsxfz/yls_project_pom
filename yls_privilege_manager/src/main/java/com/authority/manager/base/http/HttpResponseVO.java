package com.authority.manager.base.http;

import com.authority.manager.component.error.BaseErrorInfoInterface;
import com.authority.manager.base.page.PageResultVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.domain.Page;

import java.io.Serializable;

/**
 * @Author yls
 * @Description HTTP结果封装
 * @Date 2020/4/5 9:41
 **/
@ApiModel(description = "HTTP结果封装")
public class HttpResponseVO implements Serializable {

	@ApiModelProperty("状态")
	private int code = HttpStatus.SC_OK;

	@ApiModelProperty("msg信息")
	private String msg;

	@ApiModelProperty("返回数据")
	private Object data;

	public HttpResponseVO(){

	}

	public HttpResponseVO(BaseErrorInfoInterface baseErrorInfoInterface){
		this.code = baseErrorInfoInterface.getErrorCode();
		this.msg = baseErrorInfoInterface.getErrorMsg();
	}

	/**
	 * 功能描述:
	 * 〈全局异常捕获并返回〉
	 *
	 * @author : yls
	 * @date : 2020/10/20 10:50
	 * @param baseErrorInfoInterface 基础错误类
	 * @return : com.authority.manager.base.http.HttpResponseVO
	 */
	public static HttpResponseVO error(BaseErrorInfoInterface baseErrorInfoInterface) {
		return error(baseErrorInfoInterface.getErrorCode(),baseErrorInfoInterface.getErrorMsg());
	}


	/**
	 * 功能描述:
	 * 〈返回500错误信息〉
	 *
	 * @author : yls
	 * @date : 2020/10/14 9:38
	 * @return : com.authority.manager.base.http.HttpResultVO
	 */
	public static HttpResponseVO error() {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
	}

	/**
	 * 功能描述:
	 * 〈操作异常〉
	 *
	 * @author : yls
	 * @date : 2020/10/14 9:39
	 * @param msg 异常信息
	 * @return : com.authority.manager.base.http.HttpResultVO
	 */
	public static HttpResponseVO error(String msg) {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
	}

	/**
	 * 功能描述:
	 * 〈自定义错误异常〉
	 *
	 * @author : yls
	 * @date : 2020/10/14 9:39
	 * @param code 错误代码
	 * @param msg 异常信息
	 * @return : com.authority.manager.base.http.HttpResultVO
	 */
	public static HttpResponseVO error(int code, String msg) {
		HttpResponseVO r = new HttpResponseVO();
		r.setCode(code);
		r.setMsg(msg);
		return r;
	}

	/**
	 * 功能描述:
	 * 〈成功返回信息〉
	 *
	 * @author : yls
	 * @date : 2020/10/14 9:40
	 * @param msg 响应消息
	 * @return : com.authority.manager.base.http.HttpResultVO
	 */
	public static HttpResponseVO ok(String msg) {
		HttpResponseVO r = new HttpResponseVO();
		r.setMsg(msg);
		return r;
	}

	/**
	 * 功能描述:
	 * 〈成功返回〉
	 *
	 * @author : yls
	 * @date : 2020/10/14 9:40
	 * @param data 响应实体
	 * @return : com.authority.manager.base.http.HttpResultVO
	 */
	public static HttpResponseVO ok(Object data) {
		HttpResponseVO resultVO = new HttpResponseVO();
		//判断是否为分页对象
		if(data instanceof Page){
			Page page = (Page) data;
			PageResultVO pageResult = new PageResultVO();
			pageResult.setContent(page.getContent());
			pageResult.setPageNum(page.getNumber());
			pageResult.setPageSize(page.getSize());
			pageResult.setTotalPages(page.getTotalPages());
			pageResult.setTotalSize(page.getTotalElements());
			resultVO.setData(pageResult);
		}else{
			resultVO.setData(data);
		}
		return resultVO;
	}

	/**
	 * 功能描述:
	 * 〈返回成功信息〉
	 *
	 * @author : yls
	 * @date : 2020/10/14 9:43
	 * @param msg 响应信息
	 * @param data 响应数据集合
	 * @return : com.authority.manager.base.http.HttpResultVO
	 */
	public static HttpResponseVO ok(String msg, Object data) {
		HttpResponseVO httpResponseVO = ok(data);
		httpResponseVO.setMsg(msg);
		return httpResponseVO;
	}

	/**
	 * 功能描述:
	 * 〈成功返回〉
	 *
	 * @author : yls
	 * @date : 2020/10/14 9:41
	 * @return : com.authority.manager.base.http.HttpResultVO
	 */
	public static HttpResponseVO ok() {
		return new HttpResponseVO();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "HttpResult{" +
				"code=" + code +
				", msg='" + msg + '\'' +
				", data=" + data +
				'}';
	}
}
