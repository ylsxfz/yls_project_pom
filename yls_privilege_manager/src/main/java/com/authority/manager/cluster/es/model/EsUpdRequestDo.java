package com.authority.manager.cluster.es.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: yls
 * @Date: 2020/6/4 15:43
 * @Description: ES更新时条件封装
 * @Version 1.0
 */
@ApiModel(description = "ES更新时条件封装")
public class EsUpdRequestDo implements Serializable {
    /**
     * 文档id
     */
    @ApiModelProperty(value = "文档id")
    private String docId;
    /**
     * 关联案件id
     */
    @ApiModelProperty(value = "案件id")
    private String caseId;

    /**
     * 更新的内容
     */
    @ApiModelProperty(value = "需要更新的字段，采用键值对的方式")
    private Map<String,Object> fieldMap = new HashMap<>();

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public Map<String, Object> getFieldMap() {
        return fieldMap;
    }

    public void setFieldMap(Map<String, Object> fieldMap) {
        this.fieldMap = fieldMap;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    @Override
    public String toString() {
        return "EsUpdRequestDo{" +
                "docId='" + docId + '\'' +
                ", caseId='" + caseId + '\'' +
                ", fieldMap=" + fieldMap +
                '}';
    }
}
