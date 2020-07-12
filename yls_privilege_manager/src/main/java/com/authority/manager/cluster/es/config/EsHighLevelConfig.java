package com.authority.manager.cluster.es.config;

import com.authority.manager.cluster.es.model.EsRequestBO;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.entity.ContentType;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;

/**
 * @Auther: yls
 * @Date: 2020/4/23 13:10
 * @Description: es-high-level-client
 * @Version 1.0
 */
public class EsHighLevelConfig {
    private final static Logger LOGGER = LoggerFactory.getLogger(EsHighLevelConfig.class);

    public static RestHighLevelClient restHighLevelClient;

    /**
     * 功能描述:
     * 〈获取ES的高级客户端〉
     *
     * @author : yls
     * @date : 2020/6/4 12:36
     * @return : org.elasticsearch.client.RestHighLevelClient
     */
    public static void initRestHighClient(EsRequestBO requestBO){
        //组装es的请求地址
        List<String> nodes = requestBO.getNodes();
        HttpHost[] httpHosts = nodes.stream().map(host -> {
            String[] hostParts = host.split(":");
            String hostName = hostParts[0];
            int port = Integer.parseInt(hostParts[1]);
            return new HttpHost(hostName, port, "http");
        }).filter(Objects::nonNull).toArray(HttpHost[]::new);
        RestClientBuilder clientBuilder = RestClient.builder(httpHosts);

//        // 如果有多个从节点可以持续在内部new多个HttpHost，参数1是ip,参数2是HTTP端口，参数3是通信协议
//        RestClientBuilder clientBuilder = RestClient.builder(
////                new HttpHost("192.168.1.107",9200,"http")
//                new HttpHost("192.168.133.104", 9200, "http"),
//                new HttpHost("192.168.133.105", 9200, "http"),
//                new HttpHost("192.168.133.106", 9200, "http")
//        );


        // 添加其他配置，都是可选，比如设置请求头，每个请求都会带上这个请求头
        Header[] defaultHeaders = {new BasicHeader("Content-Type", ContentType.APPLICATION_JSON.toString())};
        clientBuilder.setDefaultHeaders(defaultHeaders);

        //返回客户端
        restHighLevelClient = new RestHighLevelClient(clientBuilder);
    }


    /**
     * 功能描述:
     * 〈关闭ES的高级客户端〉
     *
     * @author : yls
     * @date : 2020/6/5 16:03
     * @param restHighLevelClient es的高级客户端
     * @return : void
     */
//    public static void closeRestHighClient(RestHighLevelClient restHighLevelClient){
//        try{
//            restHighLevelClient.close();
//        }catch (Exception e){
//            e.printStackTrace();
//            LOGGER.error("客户端关闭失败："+e.getMessage());
//        }
//    }

}

