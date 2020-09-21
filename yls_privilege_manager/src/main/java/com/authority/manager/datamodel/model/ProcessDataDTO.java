package com.authority.manager.datamodel.model;

import com.yls.core.page.ParamsQuery;

import java.util.List;

/**
 * @Auther: yls
 * @Date: 2020/09/21 11:04
 * @Description:
 * @Version 1.0
 */
public class ProcessDataDTO {
    /**
     * 节点名称
     */
    private String nodeName;

    /**
     * 执行状态: true:成功 false:失败
     */
    private boolean success;


    /**
     * 异常信息，如果发生异常，才会使用该字段
     */
    private String errorMsg;


    /**
     * 携带数据集
     */
    private List<?> dataLists;

    /**
     * 请求参数
     */
    private List<ParamsQuery> paramsQueryList;

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public List<?> getDataLists() {
        return dataLists;
    }

    public void setDataLists(List<?> dataLists) {
        this.dataLists = dataLists;
    }

    public List<ParamsQuery> getParamsQueryList() {
        return paramsQueryList;
    }

    public void setParamsQueryList(List<ParamsQuery> paramsQueryList) {
        this.paramsQueryList = paramsQueryList;
    }

    @Override
    public String toString() {
        return "ProcessDataDTO{" +
                "nodeName='" + nodeName + '\'' +
                ", success=" + success +
                ", errorMsg='" + errorMsg + '\'' +
                ", dataLists=" + dataLists +
                ", paramsQueryList=" + paramsQueryList +
                '}';
    }
}
