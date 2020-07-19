package com.authority.manager.cluster.es.search;

import com.authority.manager.cluster.es.config.EsHighLevelConfig;
import com.authority.manager.cluster.es.model.EsRequestBO;
import com.authority.manager.cluster.es.model.EsUpdRequestDo;
import com.yls.core.http.HttpConstants;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * @Auther: yls
 * @Date: 2020/6/4 13:50
 * @Description:
 * @Version 1.0
 */
@Component
public class EsUpdateRequest {

    private static final Logger LOGGER = LoggerFactory.getLogger(EsUpdateRequest.class);


    /**
     * 功能描述:
     * 〈更新请求〉
     *
     * @author : yls
     * @date : 2020/6/4 14:14
     * @param esUpdRequestDo es请求对象
     * @return : void
     */
    public  Boolean updateDoc(EsRequestBO esRequestBO,EsUpdRequestDo esUpdRequestDo) {
        //1、获取客户端
        RestHighLevelClient restHighClient = EsHighLevelConfig.restHighLevelClient;
        //2、创建更新请求对象
        UpdateRequest updateRequest = getUpdateRequest(esRequestBO,esUpdRequestDo);
        //3、关联更新文档
        updateRequest.doc(esUpdRequestDo.getFieldMap());
        try{
            //执行更新
            UpdateResponse update = restHighClient.update(updateRequest, RequestOptions.DEFAULT);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            LOGGER.error(esRequestBO.toString()+"==》" + HttpConstants.UPDATE_ERROR ,e.getMessage());
        }finally {
            //EsHighLevelConfig.closeRestHighClient(restHighClient);
        }

        return false;
    }


    /**
     * 功能描述:
     * 〈创建更新请求
     *         如果request.docAsUpsert(true)和request.scriptedUpsert(true)都设置为true,且
     *         request.doc(jsonMap)被注释掉时，会报错如下：
     *         org.elasticsearch.action.ActionRequestValidationException:
     *         Validation Failed: 1: script or doc is missing;2: doc must be specified if doc_as_upsert is enabled;
     *         即如果开启动了doc_as_upsert方法，则必须使用doc方法传入需要更新的内容
     * 〉
     *
     * @author : yls
     * @date : 2020/5/2 7:45
     * @param esUpdRequestDo es请求对象
     * @return : UpdateRequest
     */
    private  UpdateRequest getUpdateRequest(EsRequestBO esRequestBO,EsUpdRequestDo esUpdRequestDo){
        //更新的请求
        UpdateRequest updateRequest = new UpdateRequest(
                esRequestBO.getIndex(),
                esRequestBO.getType(),
                esUpdRequestDo.getDocId());

        //updateRequest.routing("routing");
        //updateRequest.parent("parent");

        // 等待主分片可用的超时时间
        //updateRequest.timeout(TimeValue.timeValueSeconds(1));
        //updateRequest.timeout("3s");

        //WAIT_UNTIL 一直保持请求连接中，直接当所做的更改对于搜索查询可见时的刷新发生后，
        //再将结果返回
        //updateRequest.setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL);
        //updateRequest.setRefreshPolicy("wait_for");

        //如果更新的过程中，文档被其它线程进行更新的话，会产生冲突，这个为设置更新失败后重试的次数
        // updateRequest.retryOnConflict(3);

        // 是否将文档内容作为结果返回，默认是禁止的
        //updateRequest.fetchSource(true);
        //updateRequest.version(2);

        // NO OPeration,空操作检查,默认情况为true，只有原来的source和新的source存在不同的字段情况下才会重建索引，如果一模一样是不会触发重建索引的，如果将detect_noop=false不管内容有没有变化都会重建索引，这一点可以通过version的值的变化来发现
        // updateRequest.detectNoop(false);

        // true，表明如果文档不存在，则新更新的文档内容作为新的内容插入文档，
        // 这个和scriptedUpsert的区别是：更新文档的两种不同方式，有的使用doc方法更新有的使用脚本更新
        //updateRequest.scriptedUpsert(true);
        //updateRequest.docAsUpsert(true);

        // 设置在更新操作执行之前，要求活动状态的分片副本数；单机不要设置，否则会报错：超时
        // updateRequest.waitForActiveShards(2);
        // updateRequest.waitForActiveShards(ActiveShardCount.ALL);

        // 设置希望在返回结果中返回的字段值
        // String[] includes = new String[]{"updated", "r*"};
        // String[] excludes = Strings.EMPTY_ARRAY;
        // updateRequest.fetchSource(new FetchSourceContext(false, includes, excludes));

        // String[] includes = Strings.EMPTY_ARRAY;
        // String[] excludes = new String[]{"updated"};
        // updateRequest.fetchSource(new FetchSourceContext(true, includes, excludes));
        return updateRequest;
    }

}
