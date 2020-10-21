package com.authority.manager.cluster.es.model;


import com.authority.manager.base.page.PageResultVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.rest.RestStatus;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: yls
 * @Date: 2020/6/5 13:43
 * @Description: ES分页查询查询结果解析封装
 * @Version 1.0
 */
@ApiModel(description = "ES分页查询查询结果解析封装")
public class EsResultBO<T> implements Serializable {
    /**
     * 请求状态：是否成功
     */
    @ApiModelProperty(value = "请求状态：是否成功")
    private RestStatus status ;

    /**
     *运行时间
     */
    @ApiModelProperty(value = "运行时间")
    private TimeValue timeValue;

    /**
     *是否提前结束
     */
    @ApiModelProperty(value = "是否提前结束")
    private Boolean isTerminatedEarly ;

    /**
     * 是否超时
     */
    @ApiModelProperty(value = "是否超时")
    private boolean  isTimedOut;

    /**
     * 分片总数
     */
    @ApiModelProperty(value = "分片总数")
    private int totalShards;

    /**
     * 成功分片数
     */
    @ApiModelProperty(value = "成功分片数")
    private int successfulShards;

    /**
     * 失败分片数
     */
    @ApiModelProperty(value = "失败分片数")
    private int failedShards;


    /**
     * 总计录数
     */
    @ApiModelProperty(value = "总计录数")
    private long totalHits;

    /**
     * 最大分数
     */
    @ApiModelProperty(value = "最大分数")
    private float maxScore;

    /**
     * 查询的结果集数据
     */
    @ApiModelProperty(value = "查询的结果集数据")
    private List<T> content;

    @ApiModelProperty("分页信息")
    private PageResultVO pageResult = new PageResultVO();


    public RestStatus getStatus() {
        return status;
    }

    public void setStatus(RestStatus status) {
        this.status = status;
    }

    public TimeValue getTimeValue() {
        return timeValue;
    }

    public void setTimeValue(TimeValue timeValue) {
        this.timeValue = timeValue;
    }

    public Boolean getTerminatedEarly() {
        return isTerminatedEarly;
    }

    public void setTerminatedEarly(Boolean terminatedEarly) {
        isTerminatedEarly = terminatedEarly;
    }

    public boolean isTimedOut() {
        return isTimedOut;
    }

    public void setTimedOut(boolean timedOut) {
        isTimedOut = timedOut;
    }

    public int getTotalShards() {
        return totalShards;
    }

    public void setTotalShards(int totalShards) {
        this.totalShards = totalShards;
    }

    public int getSuccessfulShards() {
        return successfulShards;
    }

    public void setSuccessfulShards(int successfulShards) {
        this.successfulShards = successfulShards;
    }

    public int getFailedShards() {
        return failedShards;
    }

    public void setFailedShards(int failedShards) {
        this.failedShards = failedShards;
    }

    public long getTotalHits() {
        return totalHits;
    }

    public void setTotalHits(long totalHits) {
        this.totalHits = totalHits;
    }

    public float getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(float maxScore) {
        this.maxScore = maxScore;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public PageResultVO getPageResult() {
        return pageResult;
    }

    public void setPageResult(PageResultVO pageResult) {
        this.pageResult = pageResult;
    }

    @Override
    public String toString() {
        return "EsResultBO{" +
                "status=" + status +
                ", timeValue=" + timeValue +
                ", isTerminatedEarly=" + isTerminatedEarly +
                ", isTimedOut=" + isTimedOut +
                ", totalShards=" + totalShards +
                ", successfulShards=" + successfulShards +
                ", failedShards=" + failedShards +
                ", totalHits=" + totalHits +
                ", maxScore=" + maxScore +
                ", content=" + content +
                ", pageResult=" + pageResult +
                '}';
    }
}
