package com.study.config.autoConfig;

import com.study.config.ConditionalMyOnClass;
import com.study.config.MyAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;

// @Configuration  // Bean 에 등록이 됨
@MyAutoConfiguration    // Meta Annotation 에 Configuration 어노테이션이 있어 Configuration 어노테이션과 똑같은 기능을 함 
// @Conditional(TomcatWebServerConfig.TomcatCondition.class)
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat") // Conditional클래스를 직접 만듦 (Tomcat 이 있으면 True 를 반환 하므로 Tomcat 을 띄움)
public class TomcatWebServerConfig {

    @Bean("tomcatWebServerFactory")
    @ConditionalOnMissingBean   // Class Leven 에 등록 된 Bean 이 없더라면 해당 Bean 을 등록
    // class, method Level 에서도 설정 ==> 등록된 WebServer Bean 이 없다면 해당 Bean 을 등록 (다른 WebServer 등록 된 Bean 이 없다면 해당 Bean 을 WebServer 로 사용)
    // Springboot 에서 만들어져 있는 ConditionalBean 을 사용
    public ServletWebServerFactory servletWebServerFactory() {
        return new TomcatServletWebServerFactory();
    }

    // Conditional 어노테이션 사용 시 해당 matches 함수 사용
//    static class TomcatCondition implements Condition {
//        // false 로 지정 시 WebServer Bean 이 2개 일 시 true 인게 실행이 됨
//        @Override
//        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
//            // 존재 하면 True 존재하지 않으면 False 리턴
//            return ClassUtils.isPresent("org.apache.catalina.startup.Tomcat",
//                    context.getClassLoader());
//            // return false;
//        }
//    }

}
