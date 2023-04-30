package com.study.config;

import com.study.config.autoConfig.ServerProperties;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(MyConfigurationPropertiesImportsSelector.class)
public @interface EnableMyConfigurationProperties {
    Class<?> value();
}
