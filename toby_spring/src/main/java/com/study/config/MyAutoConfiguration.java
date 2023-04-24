package com.study.config;

import org.springframework.context.annotation.Configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
// @Configuration
// 지금까지 Configuration 사용 시 parameter 를 설정 하지 않았지만 proxyBeanMethods = false 설정 시
// Configuration 어노테이션은 분명히 이 직접 Application-Code 안에 원하는 Bean 을 등록해야하는 경우가 있음
@Configuration(proxyBeanMethods = false)    // default 는 true 라서 false 로 변경,
public @interface MyAutoConfiguration {
    // 설정 파일을 따로 외부파일로 뺴버림
    // com.study.config.MyAutoConfiguration.imports --> 에 아예 따로 뺴버림

    //

}
