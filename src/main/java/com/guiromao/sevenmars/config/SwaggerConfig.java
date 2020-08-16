package com.guiromao.sevenmars.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        Predicate<RequestHandler> basePackage = RequestHandlerSelectors.basePackage("com.guiromao.sevenmars");
        Predicate<String> apiUrls = PathSelectors.ant("/**");
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(basePackage)
                .paths(apiUrls)
                .build();
    }

}