package com.authority.manager.base.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 分页返回结果
 * @author Louis
 * @date Jan 12, 2019
 */
@ApiModel(description = "分页请求结果封装")
public class PageResultVO {
	/**
	 * 当前页码
	 */
	@ApiModelProperty("当前页码")
	private int pageNum;
	/**
	 * 每页数量
	 */
	@ApiModelProperty("每页数量")
	private int pageSize;
	/**
	 * 记录总数
	 */
	@ApiModelProperty("记录总数")
	private long totalSize;
	/**
	 * 页码总数
	 */
	@ApiModelProperty("页码总数")
	private long totalPages;
	/**
	 * 分页数据
	 */
	@ApiModelProperty("分页数据")
	private List<?> content;
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = Math.max(pageNum + 1, 1);
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public long getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(long totalSize) {
		this.totalSize = totalSize;
	}
	public long getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
	}
	public List<?> getContent() {
		return content;
	}
	public void setContent(List<?> content) {
		this.content = content;
	}
}
