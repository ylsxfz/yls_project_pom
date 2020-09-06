package com.authority.manager.config;

/**
 * @Auther: yls
 * @Date: 2020/8/28 13:35
 * @Description: 配置允许http方式访问，并妆发到Https上
 * @Version 1.0
 */
//@Configuration
public class TomcatConfig {
//    @Bean
//    TomcatServletWebServerFactory tomcatServletWebServerFactory(){
//        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory() {
//            @Override
//            protected void postProcessContext(Context context) {
//                SecurityConstraint constraint = new SecurityConstraint();
//                constraint.setUserConstraint("CONFIDENTIAL");
//                SecurityCollection collection = new SecurityCollection();
//                collection.addPattern("/");
//                constraint.addCollection(collection);
//                context.addConstraint(constraint);
//            }
//        };
//        factory.addAdditionalTomcatConnectors(createTomcatConnector());
//        return factory;
//    }
//
//    private Connector createTomcatConnector(){
//        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//        connector.setScheme("http");
//        connector.setPort(8443);
//        connector.setSecure(false);
//        connector.setRedirectPort(8081);
//        return connector;
//    }
}
