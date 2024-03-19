package com.haihai.hfweb.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: Knife4jConfig
 * Package: com.mcode.knife4jdemo.config
 * Description:
 *
 * @Author: robin
 * @Version: v1.0
 */
@Configuration
public class Knife4jConfig {
    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Knife4j标题")
                        .description("Knife4j说明")
                        .version("v1")
                        .contact(new Contact().name("robin").email("robin@gmail.com"))
                        .license(new License().name("Apache 2.0").url("http://springdoc.org"))
                );

    }
}
