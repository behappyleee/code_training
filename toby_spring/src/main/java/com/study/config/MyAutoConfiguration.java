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

// 기존 실습하였던 어노테이션을 주석 후 SpringBootApplication 어노테이션 사용을 위하여 주석 처리
@Configuration(proxyBeanMethods = false)    // default 는 true 라서 false 로 변경,
// falut 는 proxy 로 만들어지지 않는 다는 뜻, 객체가 싱글톤 방식으로 생성 되지 않은 default 는 싱글톤
public @interface MyAutoConfiguration {
    // 설정 파일을 따로 외부파일로 뺴버림
    // com.study.config.MyAutoConfiguration.imports --> 에 아예 따로 뺴버림

}
