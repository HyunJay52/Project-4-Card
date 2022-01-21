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
                .apis(RequestHandlerSelectors.any()) //RequestHandler를 선택하기 위한 설정을 돕는다
                .paths(PathSelectors.ant("/**")) // RequestMapping으로 할당된 모든 URL 리스트를 추출해서 화면에 노출시키는 설정
                .build();
    }

}
