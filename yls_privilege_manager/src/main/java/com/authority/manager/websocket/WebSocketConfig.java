package com.authority.manager.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * @Author yls
 * @Date 2020/3/31 10:45
 * @Description
 * @Version 1.0
 **/
@Configuration
//开启WebSocket消息代理
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //消息代理的前缀
        registry.enableSimpleBroker("/topic","/queue");
        //过滤出需要被注解方法处理的消息
        registry.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //定义一个前缀为“/chat”的endPoint，并开启sockjs的支持，
        //socketjs可以解决浏览器对websocket的兼容性问题。
        registry.addEndpoint("/chat").withSockJS();
    }
}
