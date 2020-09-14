package com.authority.manager.cluster.es.utills;

import com.alibaba.fastjson.JSON;
import com.authority.manager.cluster.es.model.EsPageRequest;
import com.authority.manager.cluster.es.model.EsResultBO;
import com.yls.core.page.MyPageResultVO;
import org.apache.poi.ss.formula.functions.T;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.ShardSearchFailure;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;

import java.util.ArrayList;
import java.util.Map;

/**
 * @Auther: yls
 * @Date: 2020/6/4 17:31
 * @Description:
 * @Version 1.0
 */
public class EsSearchResponseUtil {

    public static EsResultBO pareSearchResponse(EsPageRequest esPageRequest, SearchResponse searchResponse){
        EsResultBO esResultBO = new EsResultBO();

        //状态
        RestStatus status = searchResponse.status();
        esResultBO.setStatus(status);

        //运行时间
        TimeValue took = searchResponse.getTook();
        esResultBO.setTimeValue(took);

        //是否提前结束
        Boolean terminatedEarly = searchResponse.isTerminatedEarly();
        esResultBO.setTerminatedEarly(terminatedEarly);

        //是否超时
        boolean timedOut = searchResponse.isTimedOut();
        esResultBO.setTimedOut(timedOut);

        int totalShards = searchResponse.getTotalShards();
        int successfulShards = searchResponse.getSuccessfulShards();
        int failedShards = searchResponse.getFailedShards();
        esResultBO.setTotalShards(totalShards);
        esResultBO.setSuccessfulShards(successfulShards);
        esResultBO.setFailedShards(failedShards);

        for (ShardSearchFailure failure : searchResponse.getShardFailures()) {
            // failures should be handled here
        }

        SearchHits hits = searchResponse.getHits();
        long totalHits = hits.getTotalHits();
        float maxScore = hits.getMaxScore();
        esResultBO.setTotalHits(totalHits);
        esResultBO.setMaxScore(maxScore);

        if (esPageRequest!=null){
            MyPageResultVO pageResult = new MyPageResultVO();
            int pageSize = esPageRequest.getPageSize();
            pageResult.setPageNum(esPageRequest.getPageNum());
            pageResult.setPageSize(pageSize);
            pageResult.setTotalSize(totalHits);
            long totalPage = totalHits / pageSize;
            if (totalHits % pageSize > 0){
                totalPage += 1;
            }
            pageResult.setTotalPages(totalPage);
            esResultBO.setPageResult(pageResult);
        }

        //遍历结果
        for(SearchHit hit : searchResponse.getHits()){
            Map<String, Object> source = hit.getSourceAsMap();
            //处理高亮片段
           Map<String, HighlightField> highlightFields = hit.getHighlightFields();
           System.out.println(highlightFields);
//            HighlightField highlight = highlightFields.get("txtContent.whitespace");
//            Text[] fragments = highlight.fragments();
//            String fragmentString = fragments[0].string();

//            System.err.println(highlightFields);
//            HighlightField nameField = highlightFields.get("txtContent.whitespace");
//            if(nameField!=null){
//                Text[] fragments = nameField.fragments();
//                StringBuilder nameTmp = new StringBuilder();
//                for(Text text:fragments){
//                    nameTmp.append(text);
//                }
//                //将高亮片段组装到结果中去
//                source.put("txtContent", nameTmp.toString());
//                System.err.println(source.toString());
//            }
        }

        ArrayList<T> mailArrayList = new ArrayList<>();
        SearchHits searchHits = searchResponse.getHits();
        for (SearchHit hit:searchHits) {
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            String jsonString = JSON.toJSONString(sourceAsMap);
            T t = JSON.parseObject(jsonString, T.class);
            //t.setMailId(hit.getId());
            mailArrayList.add(t);
        }

//        int orderNum = esPageRequest.getPageNum() * esPageRequest.getPageSize();
//        for (int i = 0; i < mailArrayList.size(); i++) {
//            mailArrayList.get(i).setOrderNum(orderNum + i);
//        }
        esResultBO.setContent(mailArrayList);
        return esResultBO;
    }


    public static void main(String[] args) {
        long a =100;
        int b = 30;
        System.out.println(a/b);
    }
}
