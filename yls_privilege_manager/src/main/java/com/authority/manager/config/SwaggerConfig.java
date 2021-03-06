package com.authority.manager.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yls
 * @Description 集成swagger2 文档
 * 页面访问地址为：http://localhost:8443/swagger-ui.html
 * @Date 2020/4/5 9:15
 **/
@Configuration
@EnableSwagger2
@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

    /*******************************************************默认api-start*************************************************************/
    /**
     * 功能描述:
     * 〈swagger2 接口文档管理器〉
     *
     * @return : springfox.documentation.spring.web.plugins.Docket
     * @author : yls
     * @date : 2020/07/12 10:48
     */
    @Bean
    public Docket defaultApi() {
        List<Parameter> parameters = getParameters();
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(defaultApiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(parameters)
                /* 设置安全模式，swagger可以设置访问token */
                .securitySchemes(securitySchemes()).securityContexts(securityContexts());
    }

    /**
     * 功能描述:
     * 〈apiInfo对象主要是设置我们api文档的标题，描述，访问的地址，创建者等信息〉
     * @author : yls
     * @date : 2020/11/09 20:54
     * @param
     * @return : springfox.documentation.service.ApiInfo
     */
    @SuppressWarnings("deprecation")
    private ApiInfo defaultApiInfo() {
        return new ApiInfoBuilder()
                .title("API测试文档")
                .description("权限管理主系统测试文档")
                .contact(new Contact("权限系统主页", "http://localhost:8443/", "test@qq.com"))
                .version("v1.0")
                .license("Apache2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .build();
    }
    /*******************************************************默认api-end*************************************************************/

    /*******************************************************系统组件api-start*************************************************************/
    /**
     * 功能描述:
     * 〈swagger2 接口文档管理器〉
     *
     * @return : springfox.documentation.spring.web.plugins.Docket
     * @author : yls
     * @date : 2020/07/12 10:48
     */
    @Bean
    public Docket systemComponentApi() {
        List<Parameter> parameters = getParameters();
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(systemComponentApiInfo())
                .groupName("系统组件模块")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.authority.manager.functions"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(parameters)
                /* 设置安全模式，swagger可以设置访问token */
                .securitySchemes(securitySchemes()).securityContexts(securityContexts());
    }

    /**
     * 功能描述:
     * 〈apiInfo对象主要是设置我们api文档的标题，描述，访问的地址，创建者等信息〉
     * @author : yls
     * @date : 2020/11/09 20:54
     * @param
     * @return : springfox.documentation.service.ApiInfo
     */
    @SuppressWarnings("deprecation")
    private ApiInfo systemComponentApiInfo() {
        return new ApiInfoBuilder()
                .title("系统组件模块")
                .description("系统组件模块")
                .contact(new Contact("权限系统主页", "http://localhost:8443/", "test@qq.com"))
                .version("v1.0")
                .license("Apache2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .build();
    }
    /*******************************************************系统组件api-end*************************************************************/

    /*******************************************************系统管理api-start*************************************************************/
    /**
     * 功能描述:
     * 〈swagger2 接口文档管理器〉
     *
     * @return : springfox.documentation.spring.web.plugins.Docket
     * @author : yls
     * @date : 2020/07/12 10:48
     */
    @Bean
    public Docket systeManagementApi() {
        List<Parameter> parameters = getParameters();
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(systemManagementApiInfo())
                .groupName("系统管理模块")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.authority.manager.web"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(parameters)
                /* 设置安全模式，swagger可以设置访问token */
                .securitySchemes(securitySchemes()).securityContexts(securityContexts());
    }

    /**
     * 功能描述:
     * 〈apiInfo对象主要是设置我们api文档的标题，描述，访问的地址，创建者等信息〉
     * @author : yls
     * @date : 2020/11/09 20:54
     * @param
     * @return : springfox.documentation.service.ApiInfo
     */
    @SuppressWarnings("deprecation")
    private ApiInfo systemManagementApiInfo() {
        return new ApiInfoBuilder()
                .title("系统管理模块")
                .description("系统管理模块")
                .contact(new Contact("权限系统主页", "http://localhost:8443/", "test@qq.com"))
                .version("v1.0")
                .license("Apache2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .build();
    }
    /*******************************************************系统管理api-end*************************************************************/



    /**
     * 获取请求参数
     *
     * @return
     */
    private List<Parameter> getParameters() {
        // 添加请求参数，我们这里把token作为请求头部参数传入后端
        ParameterBuilder parameterBuilder = new ParameterBuilder();
        List<Parameter> parameters = new ArrayList<Parameter>();
        parameterBuilder.name("token").description("令牌")
                .modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        parameters.add(parameterBuilder.build());
        return parameters;
    }


    /**
     * 安全模式，这里指定token通过Authorization头请求头传递
     */
    private List<ApiKey> securitySchemes() {
        List<ApiKey> apiKeyList = new ArrayList<ApiKey>();
        apiKeyList.add(new ApiKey("Authorization", "Authorization", "header"));
        return apiKeyList;
    }

    /**
     * 安全上下文
     */
    private List<SecurityContext> securityContexts() {
        List<SecurityContext> securityContexts = new ArrayList<>();
        securityContexts.add(SecurityContext.builder().securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("^(?!auth).*$")).build());
        return securityContexts;
    }

    /**
     * 默认的安全上引用
     */
    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        List<SecurityReference> securityReferences = new ArrayList<>();
        securityReferences.add(new SecurityReference("Authorization", authorizationScopes));
        return securityReferences;
    }


}