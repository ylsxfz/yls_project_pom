package com.yls.core.page;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述:
 * 〈分页请求,参数采用键值对封装〉
 * @author : yls
 * @date : 2020/07/19 10:59
 */
public class MyPageRequest {
	/**
	 * 当前页码
	 */
	private int pageNum = 1;
	/**
	 * 每页数量
	 */
	private int pageSize = 10;
	/**
	 * 查询参数
	 */
	private Map<String, Object> params = new HashMap<>();
	
	public int getPageNum() {
		return pageNum - 1;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public Map<String, Object> getParams() {
		return params;
	}
	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	@Override
	public String toString() {
		return "MyPageRequest{" +
				"pageNum=" + pageNum +
				", pageSize=" + pageSize +
				", params=" + params +
				'}';
	}
}
