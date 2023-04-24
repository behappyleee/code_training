package com.study.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration // Configuration 어노테이션에 의하여 Bean 으로 등록을 해 줌 (Configuration 어노테이션 안에 Component 어노테이션이 있음)
public class Config {
    // Package 가 다를 시 ComponentScan 대상이 아님
    // MySpringAnnotation 안에 Import 어노테이션으로 Class 를 따로 설정을 해 줌 (해주지 않을 시 실행 안됨 Bean 등록이 안되므로)
        
    // TomcatWebServerConfig 클래스로 Bean 옮김 (Bean 을 따로따로 등록하는게 훨씬 유리 -> 따로 따로 Bean 을 등록하여야 하는 순간이 올 수 있으므로)
//    @Bean
//    public ServletWebServerFactory servletWebServerFactory() {
//        return new TomcatServletWebServerFactory();
//    }

    // DispatcherServletConfig 클래스로 옮김 Bean 등록 옮김
//    @Bean
//    public DispatcherServlet dispatcherServlet() {
//        return new DispatcherServlet();
//    }
}
