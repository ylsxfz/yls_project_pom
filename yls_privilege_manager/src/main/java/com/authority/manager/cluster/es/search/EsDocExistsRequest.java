package com.authority.manager.cluster.es.search;

import com.authority.manager.cluster.es.config.EsHighLevelConfig;
import com.authority.manager.cluster.es.model.EsRequestBO;
import com.authority.manager.base.http.HttpConstants;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Auther: yls
 * @Date: 2020/6/4 15:57
 * @Description:
 * @Version 1.0
 */

@Component
public class EsDocExistsRequest {

    private final  static Logger LOGGER = LoggerFactory.getLogger(EsDocExistsRequest.class);

    /**
     * 功能描述:
     * 〈判断文档是否存在〉
     *
     * @author : yls
     * @date : 2020/6/4 16:04
     * @param docId 文档id
     * @return : boolean
     */
    public  boolean existsDoc(String docId,EsRequestBO esRequestBO) {
        RestHighLevelClient restHighClient = EsHighLevelConfig.restHighLevelClient;
        boolean exists = false;
        try {
            exists =restHighClient.exists(createGetRequest(docId,esRequestBO), RequestOptions.DEFAULT);
        }catch (Exception e){
            e.printStackTrace();
            LOGGER.error(esRequestBO.toString()+"==》" + HttpConstants.SEARCH_ERROR ,e.getMessage());
        }finally {
           //EsHighLevelConfig.closeRestHighClient(restHighClient);
        }
        return  exists;
    }


    /**
     * 功能描述:
     * 〈创建getRequest〉
     *
     * @author : yls
     * @date : 2020/4/26 14:35
     * @param docId 文档id
     * @return : org.elasticsearch.action.get.GetRequest
     */
    public  GetRequest createGetRequest(String docId,EsRequestBO esRequestBO){
        GetRequest getRequest = new GetRequest(
                esRequestBO.getIndex(),
                esRequestBO.getType(),
                docId);
        //禁止获取存储的字段和"_source",请求的内容会减轻一些
        getRequest.fetchSourceContext(new FetchSourceContext(false));
        getRequest.storedFields("_none_");
        return getRequest;
    }
}
