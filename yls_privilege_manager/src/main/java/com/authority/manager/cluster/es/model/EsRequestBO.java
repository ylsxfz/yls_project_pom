package com.authority.manager.cluster.es.model;


import com.authority.manager.cluster.es.search.EsGetIndexRequest;
import com.yls.common.utils.StringFormatUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @Auther: yls
 * @Date: 2020/6/4 13:56
 * @Description: ES的索引、类型信息
 * @Version 1.0
 */
@Configuration
@ConfigurationProperties(prefix = EsRequestBO.ES)
@ApiModel(description = "ES的索引、类型信息")
public class EsRequestBO implements Serializable {


    //获取索引相关信息的请求
    @Autowired
    private EsGetIndexRequest esGetIndexRequest;

    final static String ES = "data.elasticsearchmain";

    /**
     * 索引
     */
    @ApiModelProperty(value = "索引前缀")
    private String indexprefix;

    /**
     * 索引
     */
    @ApiModelProperty(value = "索引")
    private String index;

    /**
     * 类型
     */
    @ApiModelProperty(value = "类型")
    private String type;

    /**
     * es的节点集合，可以多个，读取配置文件
     */
    @ApiModelProperty(value = "es的节点集合，可以多个，读取配置文件")
    private List<String> nodes;



    /**
     * 用户能够查询的es索引
     */
    @ApiModelProperty(value = "用户能够查询的es索引")
    private String[] userIndexArray = new String[0];

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public List<String> getNodes() {
        return nodes;
    }

    public void setNodes(List<String> nodes) {
        this.nodes = nodes;
    }

    public void setUserIndexArray(String[] userIndexArray) {
        this.userIndexArray = userIndexArray;
    }

    public String[] getUserIndexArray() {
        return userIndexArray;
    }


    public void setIndexprefix(String indexprefix) {
        this.indexprefix = indexprefix;
    }

    public String getIndexprefix() {
        return indexprefix;
    }

    //添加用户的索引
    public void addUserIndex(List<String> caseIdList) throws Exception {
        //判断索引是否存在
        String[] indexArray = caseIdList.stream().map(caseId -> {
            return getIndexprefix()+caseId;
        }).filter(Objects::nonNull).toArray(String[]::new);

        List<String> indexList = new ArrayList<>();
        for (String index:indexArray) {
            if (!StringFormatUtils.isNull(index)){
                boolean exists = esGetIndexRequest.exists(index);
                if (exists){
                    indexList.add(index);
                }
            }
        }

        String[] indexArrays = indexList.stream().filter(Objects::nonNull).toArray(String[]::new);
        this.setUserIndexArray(indexArrays);
    }

    @Override
    public String toString() {
        return "EsRequestBO{" +
                "esGetIndexRequest=" + esGetIndexRequest +
                ", indexprefix='" + indexprefix + '\'' +
                ", index='" + index + '\'' +
                ", type='" + type + '\'' +
                ", nodes=" + nodes +
                ", userIndexArray=" + Arrays.toString(userIndexArray) +
                '}';
    }
}
