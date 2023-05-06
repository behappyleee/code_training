package com.study.config.autoConfig;

import com.study.config.MyAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@MyAutoConfiguration
public class PropertyPlaceHolderConfig {
    
    // Spring 에서 개발을 해둔 Configurer
    // Bean 정보를 모두 모은 뒤 후처리를 진행
    @Bean
    PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
