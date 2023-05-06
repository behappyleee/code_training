package com.study.config;

import com.study.config.EnableMyAutoConfiguration;
import com.study.config.autoConfig.DispatcherServletConfig;
import com.study.config.autoConfig.TomcatWebServerConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // Runtime 까지 살아 있을 수 있도록, Runtime 은 default 값은 Class 임
@Target(ElementType.TYPE)   // TPYE 은 Class / Interface / Enum 적용 시 Target 을 TYPE 으로 줌
@ComponentScan
@Configuration
// @Import(Config.class)
// Import 문 EnableMyAutoConfiguration 어노테이션으로 옮김
// @Import({DispatcherServletConfig.class, TomcatWebServerConfig.class})   // Bean 을 나누어서 따로따로 Import 를 해 줌
@EnableMyAutoConfiguration
public @interface MySpringAnnotation {

}
