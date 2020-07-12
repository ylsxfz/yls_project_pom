package com.authority.manager.cluster.es.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Auther: yls
 * @Date: 2020/6/5 12:58
 * @Description: ES条件查询的范围查询封装
 * @Version 1.0
 */
@ApiModel(description = "ES条件查询的范围查询封装")
public class EsRangeBO implements Serializable {
    /**
     * 最小值
     */
    @ApiModelProperty(value = "最小值")
    private Object minValue;

    /**
     *最小值得比较符
     */
    @ApiModelProperty(value = "最小值得比较符，默认为 >=")
    private String minComparator = ">=";

    /**
     *最大值
     */
    @ApiModelProperty(value = "最大值")
    private Object maxValue;

    /**
     *最大值的比较符
     */
    @ApiModelProperty(value = "最大值的比较符,默认为 <=")
    private String maxComparator = "<=";

    public Object getMinValue() {
        return minValue;
    }

    public void setMinValue(Object minValue) {
        this.minValue = minValue;
    }

    public String getMinComparator() {
        return minComparator;
    }

    public void setMinComparator(String minComparator) {
        this.minComparator = minComparator;
    }

    public Object getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Object maxValue) {
        this.maxValue = maxValue;
    }

    public String getMaxComparator() {
        return maxComparator;
    }

    public void setMaxComparator(String maxComparator) {
        this.maxComparator = maxComparator;
    }

    @Override
    public String toString() {
        return "EsRangeBO{" +
                "minValue=" + minValue +
                ", minComparator='" + minComparator + '\'' +
                ", maxValue=" + maxValue +
                ", maxComparator='" + maxComparator + '\'' +
                '}';
    }
}
