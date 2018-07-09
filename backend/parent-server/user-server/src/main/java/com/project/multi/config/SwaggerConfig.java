package com.project.multi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.Api;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
class SwaggerConfig {

	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                    .paths(PathSelectors.any())
                    .build();
    }

    /**
     * Generate Api Info
     *
     * @return Swagger API Info
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("User Server")
                .description("Servidor de gestion de usuarios")
                .version("0.1-SNAPSHOT")
                .license("Open source licensing")
                .licenseUrl("https://help.github.com/articles/open-source-licensing/")
                .build();
    }
}
