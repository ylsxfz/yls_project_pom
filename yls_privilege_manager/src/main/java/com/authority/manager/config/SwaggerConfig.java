package com.authority.manager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yls
 * @Description 集成swagger2 文档
 *              页面访问地址为：http://localhost:8443/swagger-ui.html
 * @Date 2020/4/5 9:15
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * 功能描述:
     * 〈swagger2 接口文档管理器〉
     * @author : yls
     * @date : 2020/07/12 10:48
     * @param
     * @return : springfox.documentation.spring.web.plugins.Docket
     */
    @Bean
    public Docket createRestApi(){
        // 添加请求参数，我们这里把token作为请求头部参数传入后端
        ParameterBuilder parameterBuilder = new ParameterBuilder();
        List<Parameter> parameters = new ArrayList<Parameter>();
        parameterBuilder.name("token").description("令牌")
                .modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        parameters.add(parameterBuilder.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(
                        new ApiInfoBuilder()
                                .description("权限管理主系统测试文档")
                                .contact(new Contact("权限系统主页","http://localhost:8443/","test@qq.com"))
                                .version("v1.0")
                                .title("API测试文档")
                                .license("Apache2.0")
                                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                                .build()
                )
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(parameters);

        //return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
        		//.apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo(ApiInfo 权限管理主系统测试文档){
        return new ApiInfoBuilder().build();
    }

}