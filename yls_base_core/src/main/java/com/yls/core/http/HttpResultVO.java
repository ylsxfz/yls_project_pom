package com.yls.core.http;

import com.yls.core.page.PageResultVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.domain.Page;

/**
 * @Author yls
 * @Description HTTP结果封装
 * @Date 2020/4/5 9:41
 **/
@ApiModel(description = "HTTP结果封装")
public class HttpResultVO {

	@ApiModelProperty("状态")
	private int code = 200;
	@ApiModelProperty("msg信息")
	private String msg;
	@ApiModelProperty("返回数据")
	private Object data;
	
	public static HttpResultVO error() {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
	}
	
	public static HttpResultVO error(String msg) {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
	}
	
	public static HttpResultVO error(int code, String msg) {
		HttpResultVO r = new HttpResultVO();
		r.setCode(code);
		r.setMsg(msg);
		return r;
	}

	public static HttpResultVO ok(String msg) {
		HttpResultVO r = new HttpResultVO();
		r.setMsg(msg);
		return r;
	}
	
	public static HttpResultVO ok(Object data) {
		HttpResultVO r = new HttpResultVO();
		//判断是否为分页对象
		if(data instanceof Page){
			Page page = (Page) data;
			PageResultVO pageResult = new PageResultVO();
			pageResult.setContent(page.getContent());
			pageResult.setPageNum(page.getNumber()+1);
			pageResult.setPageSize(page.getSize());
			pageResult.setTotalPages(page.getTotalPages());
			pageResult.setTotalSize(page.getTotalElements());
			r.setData(pageResult);
		}else{
			r.setData(data);
		}
		return r;
	}
	
	public static HttpResultVO ok() {
		return new HttpResultVO();
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
