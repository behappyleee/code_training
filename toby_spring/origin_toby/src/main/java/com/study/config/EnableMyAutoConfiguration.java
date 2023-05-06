package com.study.config;

import com.study.config.autoConfig.DispatcherServletConfig;
import com.study.config.autoConfig.TomcatWebServerConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
// 만약 밑에 MyAutoConfigImportSelector.class 를 사용하지 않을 시 밑에 처럼 계속 클래스를 import 해주어야 함
// @Import({DispatcherServletConfig.class, TomcatWebServerConfig.class})  // 해당 어노테이션을 사용 시 동적으로 Annotation 등록 class 받아 사용할 수 있음
@Import(MyAutoConfigImportsSelector.class)  // 해당 어노테이션을 사용 시 동적으로 Annotation 등록 class 받아 사용할 수 있음
public @interface EnableMyAutoConfiguration {

}
