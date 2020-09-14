package com.yls.core.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 功能描述:
 * 〈分页请求,参数采用键值对封装〉
 * @author : yls
 * @date : 2020/07/19 10:59
 */
@ApiModel(description = "分页请求封装")
public class MyPageQuery {
	/**
	 * 当前页码
	 */
	@ApiModelProperty("当前页码")
	private int pageNum = 1;
	/**
	 * 每页数量
	 */
	@ApiModelProperty("每页数量")
	private int pageSize = 10;
	/**
	 * 查询参数
	 */
	@ApiModelProperty("查询参数")
	private List<Params> params;

	
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

	public List<Params> getParams() {
		return params;
	}

	public void setParams(List<Params> params) {
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
