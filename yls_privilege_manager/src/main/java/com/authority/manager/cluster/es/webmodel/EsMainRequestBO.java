package com.authority.manager.cluster.es.webmodel;


import com.authority.manager.cluster.es.model.EsRequestBO;
import io.swagger.annotations.ApiModel;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: yls
 * @Date: 2020/6/4 13:56
 * @Description: ES的索引、类型信息
 * @Version 1.0
 */
@Configuration
@ConfigurationProperties(prefix = EsMainRequestBO.ES)
@ApiModel(description = "ES的索引、类型信息")
public class EsMainRequestBO extends EsRequestBO {

    final static String ES = "data.elasticsearch.main";

    @Override
    public String toString() {
        return "EsMainRequestBO:"+this.getIndex()+":"+this.getType()+":"+this.getIndexprefix()+":"+this.getNodes();
    }
}
