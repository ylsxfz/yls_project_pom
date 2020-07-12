package com.authority.manager.cluster.es.search;


import com.authority.manager.cluster.es.config.EsHighLevelConfig;
import com.authority.manager.cluster.es.model.EsRequestBO;
import com.yls.core.http.HttpConstants;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Auther: yls
 * @Date: 2020/6/4 15:54
 * @Description:
 * @Version 1.0
 */
@Component
public class EsGetRequest {

    private static final Logger LOGGER = LoggerFactory.getLogger(EsGetRequest.class);


    @Autowired
    private EsRequestBO esRequestBO;

    /**
     * 功能描述:
     * 〈通过文档id获取文档〉
     *
     * @author : yls
     * @date : 2020/6/4 16:35
     * @param docId 文档id
     * @return : void
     */
    public   void  getDocById(String docId){
        GetRequest getRequest = createGetRequest(docId);
        //获取客户端
        RestHighLevelClient restHighClient = EsHighLevelConfig.restHighLevelClient;
        try {
            GetResponse getResponse = restHighClient.get(getRequest, RequestOptions.DEFAULT);
            pareResponse(getResponse);
        }catch (Exception e){
            e.printStackTrace();
            LOGGER.error(esRequestBO.toString()+"==》" + HttpConstants.SEARCH_ERROR ,e.getMessage());
        }finally {
            //EsHighLevelConfig.closeRestHighClient(restHighClient);
        }
    }


    /**
     * 功能描述:
     * 〈解析response〉
     *
     * @param getResponse get请求执行完的返回信息
     * @return : void
     * @author : yls
     * @date : 2020/4/23 15:35
     */
    private  void pareResponse(GetResponse getResponse) {
        String index = getResponse.getIndex();
        String type = getResponse.getType();
        String id = getResponse.getId();
        if (getResponse.isExists()) {
            long version = getResponse.getVersion();
            String sourceAsString = getResponse.getSourceAsString();
            Map<String, Object> sourceAsMap = getResponse.getSourceAsMap();
            byte[] sourceAsBytes = getResponse.getSourceAsBytes();
        } else {

        }
    }

    /**
     * 功能描述:
     * 〈es的getRequest的使用〉
     *
     * @author : yls
     * @date : 2020/4/23 15:51
     * @param docId 索引，type，文档id
     * @return : org.elasticsearch.action.get.GetRequest
     */
    public  GetRequest createGetRequest(String docId){
        GetRequest getRequest = new GetRequest(
                esRequestBO.getIndex(),
                esRequestBO.getType(),
                docId);

        //过滤具体内容:{"_index":"posts","_type":"doc","_id":"1","_version":4,"found":true}
        //getRequest.fetchSourceContext(FetchSourceContext.DO_NOT_FETCH_SOURCE);

        //指定查询字段：
        //{"_index":"posts","_type":"doc","_id":"1","_version":4,"found":true,"_source":
        //{"postDate":"2013-01-30","message":"trying out Elasticsearch"}}
        //String[] includes = new String[]{"message","*Date"};
        //过滤字段
        //String[] excludes = Strings.EMPTY_ARRAY;
        //FetchSourceContext fetchSourceContext = new FetchSourceContext(true, includes, excludes);
        //getRequest.fetchSourceContext(fetchSourceContext);
        //getRequest.storedFields("message");

        //路由值
        //getRequest.routing("routing");
        //父值
        //getRequest.parent("parent");
        //偏好值
        //getRequest.preference("preference");
        //实时标志
        //getRequest.realtime(false);
        //检索文档之前刷新
        //getRequest.refresh(true);
        //指定版本
        //getRequest.version(4);
        //版本类型
        //getRequest.versionType(VersionType.EXTERNAL);
        return getRequest;
    }

}
