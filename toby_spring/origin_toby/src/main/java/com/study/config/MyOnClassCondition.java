package com.study.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;

import java.util.Map;

public class MyOnClassCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // Annotation 의 정보들을 Map 형태로 모두 리턴을 해 줌
        Map <String, Object> attrs = metadata.getAnnotationAttributes(ConditionalMyOnClass.class.getName());
        String value = (String) attrs.get("value");

        // 여기에 해당 하는 클래스가 존재하면 True 존재하지 않으면 False build.gradle 에서 Tomcat Or Jetty 를 사용
        return ClassUtils.isPresent(value, context.getClassLoader());
    }

}
