package com.rl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author ronglin
 * @version 1.0
 * @crate_time 2021/10/12 16:39
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/") //拦截所有路径，都经过swagger
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.rl.controller")) //要扫描的包
                .paths(PathSelectors.any())
                //以下都是一些版本信息，描述等等
                .build().apiInfo(new ApiInfoBuilder()
                        .title("商品后台管理")
                        .description("商品后台管理，详细信息......")
                        .version("1.0")
                        .contact(new Contact("啊啊啊啊","blog.csdn.net","aaa@gmail.com"))
                        .license("The Apache License")
                        .licenseUrl("http://www.baidu.com")
                        .build());
    }



}
