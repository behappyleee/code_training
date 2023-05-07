package com.my.study_toby.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(MyAutoConfigurationSelector.class)
public @interface MyEanbleAutoConfiguration {

    // Servlet WebServer Factory 를 정의 해 주어야 함 !


}
