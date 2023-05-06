package com.study.config.autoConfig;

import com.study.config.MyAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

// @Configuration
@MyAutoConfiguration// Meta Annotation 에 Configuration 어노테이션이 있어 Configuration 어노테이션과 똑같은 기능을 함
public class DispatcherServletConfig {

    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }

}
