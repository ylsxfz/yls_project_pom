package com.authority.manager.base.page;

import com.authority.manager.base.utils.JsonUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.HashMap;
import java.util.List;

/**
 * 功能描述:
 * 〈分页请求,参数采用键值对封装〉
 *
 * @author : yls
 * @date : 2020/07/19 10:59
 */
@ApiModel(description = "分页请求封装")
public class PageRequstQuery {
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
    private List<ParamsQuery> params;

    /**
     * 功能描述:
     * 〈获取当前的页码：前台页面的页码是从1开始的，后台jpa封装的页码是从0开始的，所以减1〉
     *
     * @param
     * @return : int
     * @author : yls
     * @date : 2020/10/14 9:48
     */
    public int getPageNum() {
        return Math.min(pageNum - 1, 0);
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    /**
     * 功能描述:
     * 〈获取每页的显示数据：为了安全考虑，每页的最大数量为1000，
	 * 如果每页的数据超过1000条，默认只显示1000条〉
     *
     * @param
     * @return : int
     * @author : yls
     * @date : 2020/10/14 10:14
     */
    public int getPageSize() {
        if (pageSize==0){
            pageSize=1;
        }
        return Math.min(pageSize, 1000);
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 功能描述:
     * 〈分页的额外条件：该获取的查询条件不要直接使用与数据查询
     * 不然可能出现sql注入风险，可以使用{@link PageRequstQuery#conversion(Class)}
     * 方法转换后使用
     * 〉
     *
     * @param
     * @return : java.util.List<com.authority.manager.base.page.ParamsQuery>
     * @author : yls
     * @date : 2020/10/14 10:11
     */
    public List<ParamsQuery> getParams() {
        return params;
    }

    public void setParams(List<ParamsQuery> params) {
        this.params = params;
    }

    /**
     * 功能描述:
     * 〈条件转换为对象〉
     *
     * @param tClass 对象类型
     * @return : T
     * @author : yls
     * @date : 2020/10/14 10:11
     */
    public <T> T conversion(Class<T> tClass) {
        HashMap<Object, Object> map = new HashMap<>();
        for (ParamsQuery query :
                this.params) {
            map.put(query.getField(), query.getValue());
        }
        return JsonUtils.jsonToPojo(JsonUtils.objectToJson(map), tClass);
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
