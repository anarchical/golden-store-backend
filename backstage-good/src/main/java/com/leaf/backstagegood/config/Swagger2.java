package com.leaf.backstagegood.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author YeYaqiao
 * @email yaqiao.ye@mobilityasia.com.cn
 * @time 2020-02-25 21:08
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SwaggerDemo")
                .description("SwaggerLearning")
                .version("0.0.1")
                .build();
    }

    @Bean
    public Docket productApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }
}
