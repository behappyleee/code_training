package com.my.study_toby.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;

import java.util.Map;

public class MyOnClassCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> attrs = metadata.getAnnotationAttributes(
                ConditionalMyOnClass.class.getName());
        String value = (String) attrs.get("value");

        System.out.println("VALUE MATCHES DATA 모두 가져옴 : " + value);

        return ClassUtils.isPresent(value, context.getClassLoader());
    }

}
