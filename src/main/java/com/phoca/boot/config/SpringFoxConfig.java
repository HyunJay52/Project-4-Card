package com.phoca.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {

    //Docket been에서 select() 메서드는 ApiSelectorBuilder 인스턴스를 리턴하여,  Swagger에 의해 노출 된 엔드 포인트를 제어하는 방법을 제공
    @Bean
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any()) //.apis(): API 문서를 만들어줄 범위를 지정
                .paths(PathSelectors.ant("/**")) //하위 경로를 가지는 API에 대해 문서를 생성
                .build();

    //부가적으로 API 문서에 대한 내용을 수정하거나 추가하고 싶을때
        /*     private ApiInfo apiInfo() {
                return new ApiInfoBuilder()
                        .title("제목 작성")
                        .version("버전 작성")
                        .description("설명 작성")
                        .license("라이센스 작성")
                        .licenseUrl("라이센스 URL 작성")
                        .build();
        }*/


    }

}
