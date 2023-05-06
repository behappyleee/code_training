package com.study.config.autoConfig;

import com.study.config.MyAutoConfiguration;
import com.study.config.MyConfigurationProperties;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.env.Environment;

import java.util.Map;

@MyAutoConfiguration
public class PropertyPostProcessorConfig {

    @Bean
    BeanPostProcessor propertyPostProcessor(Environment env) {
        return new BeanPostProcessor() {
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                // 모든 Bean Object 를 만들 때 마다 해당 메서드가 실행이 됨
                // bean Util 에서 어노테이션을 찾아줌
                MyConfigurationProperties annotation = AnnotationUtils.findAnnotation(bean.getClass(), MyConfigurationProperties.class);

                // 찾은게 없으면 그냥 그대로 return
                if(annotation == null) return bean;
                
                // 모든 Property 정보들을 Map 형태로 받게 됨
                Map<String, Object> attrs = AnnotationUtils.getAnnotationAttributes(annotation);
                String prefix = (String)attrs.get("prefix");


                // return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
                // MyConfigurationProperty 어노테이션이 붙어있는 경우에는 값을 binding 한다는 의미
                // property binding 을 할 때 앞에 prefix 값을 붙여서 binding 을 해 줌
                return Binder.get(env).bindOrCreate(prefix, bean.getClass());
            }
        };
    }

}
