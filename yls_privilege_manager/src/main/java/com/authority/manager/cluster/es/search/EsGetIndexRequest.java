package com.authority.manager.cluster.es.search;

import com.authority.manager.cluster.es.config.EsHighLevelConfig;
import org.elasticsearch.action.admin.indices.get.GetIndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Auther: yls
 * @Date: 2020/6/17 14:14
 * @Description: 获取es的索引信息
 * @Version 1.0
 */
@Component
public class EsGetIndexRequest {

    private final static Logger LOGGER = LoggerFactory.getLogger(EsGetIndexRequest.class);


    /**
     * 功能描述:
     * 〈根据索引名称判断索引是否存在〉
     *
     * @param index 索引名称
     * @return : boolean   true：存在  false：不存在
     * @author : yls
     * @date : 2020/6/17 15:14
     */
    public boolean exists(String index)throws Exception {
        RestHighLevelClient restHighClient = EsHighLevelConfig.restHighLevelClient;
        GetIndexRequest getIndexRequest = createGetIndexRequest(index);
        LOGGER.info("检索es索引是否存在"+index);
        return restHighClient.indices().exists(getIndexRequest, RequestOptions.DEFAULT);

    }


    /**
     * 功能描述:
     * 〈创建获取索引的请求〉
     *
     * @param index
     * @return : org.elasticsearch.action.admin.indices.get.GetIndexRequest
     * @author : yls
     * @date : 2020/6/17 14:51
     */
    public GetIndexRequest createGetIndexRequest(String index) {
        GetIndexRequest getIndexRequest = new GetIndexRequest();
        getIndexRequest.indices(index);
        return getIndexRequest;
    }
}
