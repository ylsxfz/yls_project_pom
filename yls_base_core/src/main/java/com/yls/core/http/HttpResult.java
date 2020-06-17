package com.yls.core.http;

import com.yls.core.page.MyPageResult;
import org.springframework.data.domain.Page;

/**
 * @Author yls
 * @Description HTTP结果封装
 * @Date 2020/4/5 9:41
 **/
public class HttpResult {

	private int code = 200;
	private String msg;
	private Object data;
	
	public static HttpResult error() {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
	}
	
	public static HttpResult error(String msg) {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
	}
	
	public static HttpResult error(int code, String msg) {
		HttpResult r = new HttpResult();
		r.setCode(code);
		r.setMsg(msg);
		return r;
	}

	public static HttpResult ok(String msg) {
		HttpResult r = new HttpResult();
		r.setMsg(msg);
		return r;
	}
	
	public static  HttpResult ok(Object data) {
		HttpResult r = new HttpResult();
		//判断是否为分页对象
		if(data instanceof Page){
			Page page = (Page) data;
			MyPageResult pageResult = new MyPageResult();
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
	
	public static HttpResult ok() {
		return new HttpResult();
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
