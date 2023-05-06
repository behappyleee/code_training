package com.study.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)  // TYPE 은 Marking 하는 역할 Configuration 클래스에 사용하는 클래스
public @interface MyConfigurationProperties {
    String prefix();
}
