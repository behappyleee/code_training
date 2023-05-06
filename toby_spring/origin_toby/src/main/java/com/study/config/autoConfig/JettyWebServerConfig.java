package com.study.config.autoConfig;

import com.study.config.ConditionalMyOnClass;
import com.study.config.MyAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;


@MyAutoConfiguration
// @Conditional(JettyWebServerConfig.JettyCondition.class)  // Conditional 어노테이션 사용 (due to multiple ServletWebServerFactory beans : ERROR 발생)
@ConditionalMyOnClass("org.eclipse.jetty.server.Server")  // Conditional 어노테이션을 직접 만들어 서 사용 (해당 클래스가 존재하면 True 존재하지 않으며 False)
// TomcatWebServerConfig 와 JettyWebServerConfig 2개 WebServer 를 사용하여서 그럼
public class JettyWebServerConfig {

    @Bean("jettyWebServerFactory")
    public ServletWebServerFactory servletWebServerFactory() {
        return new JettyServletWebServerFactory();
    }
    
    // Conditional 어노테이션 사용 시 해당 matches 함수 사용
//    static class JettyCondition implements Condition {
//        // JettyConditional 에서 True Return 하도록 설정
//        @Override
//        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
//            // 존재 하면 True 존재하지 않으면 False
//            return ClassUtils.isPresent("org.eclipse.jetty.server.Server",
//                    context.getClassLoader());
//            //return true;
//        }
//    }

}
