package com.study.config.autoConfig;

import com.study.config.MyAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration  // Bean 에 등록이 됨
@MyAutoConfiguration    // Meta Annotation 에 Configuration 어노테이션이 있어 Configuration 어노테이션과 똑같은 기능을 함 
public class TomcatWebServerConfig {
    @Bean
    public ServletWebServerFactory servletWebServerFactory() {
        return new TomcatServletWebServerFactory();
    }

}
