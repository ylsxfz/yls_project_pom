package com.authority.manager.cluster.es.search;


import com.authority.manager.cluster.es.config.EsHighLevelConfig;
import com.authority.manager.cluster.es.model.EsPageRequest;
import com.authority.manager.cluster.es.model.EsRequestBO;
import com.authority.manager.cluster.es.model.EsResultBO;
import com.authority.manager.cluster.es.utills.EsQueryBuilderUtil;
import com.authority.manager.cluster.es.utills.EsSearchResponseUtil;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: yls
 * @Date: 2020/6/4 12:52
 * @Description:
 * @Version 1.0
 */
@Component
public class EsSearchRequest {

    private static final Logger LOGGER = LoggerFactory.getLogger(EsPageRequest.class);

    @Autowired
    private EsRequestBO esRequestBO;

    /**
     * 功能描述:
     * 〈全文检索〉
     *
     * @author : yls
     * @date : 2020/6/4 17:55
     * @param esPageRequest 分页的请求信息
     * @param queryBuilder 查询的类型
     * @return : void
     */
    public EsResultBO fullTextSearch(EsPageRequest esPageRequest, QueryBuilder queryBuilder) throws IOException {

        RestHighLevelClient restHighClient = EsHighLevelConfig.restHighLevelClient;
        //获取request
        SearchRequest searchRequest = createSearchRequest();
        SearchSourceBuilder sourceBuilder = getSourceBuilder(esPageRequest,queryBuilder);

        //绑定查询builder
        searchRequest.source(sourceBuilder);
        LOGGER.info("查询请求："+searchRequest.toString());
        SearchResponse search = restHighClient.search(searchRequest, RequestOptions.DEFAULT);
       // EsHighLevelConfig.closeRestHighClient(restHighClient);
        EsResultBO esResultBO = EsSearchResponseUtil.pareSearchResponse(esPageRequest,search);
        LOGGER.error(sourceBuilder.toString());
        return esResultBO;
    }

    /**
     * 功能描述:
     * 〈上一封、下一封查询〉
     *
     * @author : yls
     * @date : 2020/6/22 10:05
     * @param esPageRequest
     * @param queryBuilder
     * @return : com.jw.mailserver.base.es.model.EsResultBO
     */
    public  EsResultBO previousOrNextMail(EsPageRequest esPageRequest, QueryBuilder queryBuilder) throws IOException {

        RestHighLevelClient restHighClient = EsHighLevelConfig.restHighLevelClient;
        //获取request
        SearchRequest searchRequest = createSearchRequest();
        SearchSourceBuilder sourceBuilder = getSourceBuilder(esPageRequest,queryBuilder);
        sourceBuilder.from(esPageRequest.getOrderNumber());
        sourceBuilder.size(1);
        //绑定查询builder
        searchRequest.source(sourceBuilder);
        LOGGER.info("查询请求："+searchRequest.toString());
        SearchResponse search = restHighClient.search(searchRequest, RequestOptions.DEFAULT);
        // EsHighLevelConfig.closeRestHighClient(restHighClient);
        EsResultBO esResultBO = EsSearchResponseUtil.pareSearchResponse(esPageRequest,search);
        LOGGER.error(sourceBuilder.toString());
        return esResultBO;
    }


    /**
     * 功能描述:
     * 〈单个字段查询〉
     *
     * @author : yls
     * @date : 2020/6/4 17:01
     * @param esPageRequest 单条件查询
     * @return : org.elasticsearch.search.builder.SearchSourceBuilder
     */
    public  SearchSourceBuilder getSourceBuilder(EsPageRequest esPageRequest, QueryBuilder queryBuilder){
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        Map<String, Object> fieldMap = esPageRequest.getFieldValueMap();
        Set<String> fields = fieldMap.keySet();
        String highField = null;
        //拼接单条件查询
        for (String field:fields) {
            highField = field;
            break;
        }
        sourceBuilder.query(queryBuilder);
        sourceBuilder.from(esPageRequest.getPageStart());
        sourceBuilder.size(esPageRequest.getPageSize());
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

        //获取高亮规则
        if (highField!=null){
            HighlightBuilder highlighBuilder = EsQueryBuilderUtil.getHighlighBuilder(highField);
            sourceBuilder.highlighter(highlighBuilder);
        }

        //设置排序:按照邮件的发送日期排序
        sourceBuilder.sort("sentDate", SortOrder.DESC);

        return sourceBuilder;
    }

    /**
     * 功能描述:
     * 〈获取查询SearchRequest〉
     *
     * @author : yls
     * @date : 2020/6/4 16:49
     * @return : org.elasticsearch.action.search.SearchRequest
     */
    public  SearchRequest createSearchRequest(){
        SearchRequest searchRequest = new SearchRequest(esRequestBO.getUserIndexArray());
        searchRequest.types(esRequestBO.getType());
        return searchRequest;
    }


}
