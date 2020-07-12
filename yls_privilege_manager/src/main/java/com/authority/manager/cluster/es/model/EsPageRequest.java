package com.authority.manager.cluster.es.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: yls
 * @Date: 2020/6/4 17:08
 * @Description: ES分页查询封装
 * @Version 1.0
 */
@ApiModel(description = "ES分页查询封装")
public class EsPageRequest implements Serializable {
    /**
     * 当前页码
     */
    @ApiModelProperty(value = "当前页码")
    private int pageNum = 1;

    /**
     * 每页数量
     */
    @ApiModelProperty(value = "每页数量")
    private int pageSize = 20;

    @ApiModelProperty(value = "当前记录的序号")
    private int orderNumber = 0;

    /**
     * 级联查询
     */
    @ApiModelProperty(value = "级联查询，true为级联查询，false为不连续查询")
    private boolean hierarchicalQueries;

    /**
     * 级联查询的redis的缓存key
     */
    @ApiModelProperty(value = "用于redis的缓存key，拼接查询条件")
    private String hierarchicalQueriesKey;

    /**
     *查询的field
     */
    @ApiModelProperty(value = "单个字段查询：field")
    private String field;

    /**
     *单个值匹配
     */
    @ApiModelProperty(value = "单个值匹配（单字段查询时有效）")
    private Object fieldValue;

    /**
     * 多个值匹配
     */
    @ApiModelProperty(value = "多个值匹配（单字段查询时有效）")
    private List<Object> fieldValueList = new ArrayList<>();

    /**
     * 条件查询
     */
    @ApiModelProperty(value = "条件查询（多个字段查询时有效）")
    private Map<String,Object> fieldValueMap = new HashMap<>();

    /**
     * 范围性条件
     */
    @ApiModelProperty(value = "范围性条件（可以多个字段查询）")
    private Map<String,EsRangeBO> rangFieldMap = new HashMap<>();

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


    public int getPageStart(){
        return this.getPageNum()*pageSize;
    }

    public Map<String, Object> getFieldValueMap() {
        return fieldValueMap;
    }

    public void setFieldValueMap(Map<String, Object> fieldValueMap) {
        if (fieldValueMap==null){
            fieldValueMap = new HashMap<>();
        }
        this.fieldValueMap = fieldValueMap;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Object getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(Object fieldValue) {
        this.fieldValue = fieldValue;
    }

    public List<Object> getFieldValueList() {
        return fieldValueList;
    }

    public void setFieldValueList(List<Object> fieldValueList) {
        if (fieldValueList==null){
            fieldValueList = new ArrayList<>();
        }
        this.fieldValueList = fieldValueList;
    }

    public Map<String, EsRangeBO> getRangFieldMap() {
        return rangFieldMap;
    }

    public void setRangFieldMap(Map<String, EsRangeBO> rangFieldMap) {
        if (rangFieldMap==null){
            rangFieldMap = new HashMap<>();
        }
        this.rangFieldMap = rangFieldMap;
    }



    public String getHierarchicalQueriesKey() {
        return hierarchicalQueriesKey;
    }

    public void setHierarchicalQueriesKey(String hierarchicalQueriesKey) {
        this.hierarchicalQueriesKey = hierarchicalQueriesKey;
    }


    public boolean isHierarchicalQueries() {
        return hierarchicalQueries;
    }

    public void setHierarchicalQueries(boolean hierarchicalQueries) {
        this.hierarchicalQueries = hierarchicalQueries;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    @Override
    public String toString() {
        return "EsPageRequest{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", orderNumber=" + orderNumber +
                ", hierarchicalQueries=" + hierarchicalQueries +
                ", hierarchicalQueriesKey='" + hierarchicalQueriesKey + '\'' +
                ", field='" + field + '\'' +
                ", fieldValue=" + fieldValue +
                ", fieldValueList=" + fieldValueList +
                ", fieldValueMap=" + fieldValueMap +
                ", rangFieldMap=" + rangFieldMap +
                '}';
    }
}
