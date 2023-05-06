package com.study.toby_spring;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Annotation 을 생성 시 꼭 붙여주어야 하는 2개
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
// Component 가 붙었다는 것은 Spring 에 Bean Object 가 붙음
@Component  // Component 어노테이션이 붙어 있으므로 스프링 프레임워크에서 Bean 으로 등록이 됨 !
public @interface MyComponent {


}
