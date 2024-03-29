package com.study.toby_spring;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class WebServerConfiguration {
    
    // Bean 으로 등록이 됨
    // 해당 Bean 이 등록 될 시 Custom 한 TomcatWebServer 가 등록이 됨
//    @Bean
//    ServletWebServerFactory customWebServerFactory() {
//        TomcatServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
//        serverFactory.setPort(9090);    // Default Port 로 설정
//        return serverFactory;
//    }

}
