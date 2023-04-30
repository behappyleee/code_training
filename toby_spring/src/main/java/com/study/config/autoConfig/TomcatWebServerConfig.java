package com.study.config.autoConfig;

import com.study.config.ConditionalMyOnClass;
import com.study.config.MyAutoConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;

// @Configuration  // Bean 에 등록이 됨
@MyAutoConfiguration    // Meta Annotation 에 Configuration 어노테이션이 있어 Configuration 어노테이션과 똑같은 기능을 함
// @Conditional(TomcatWebServerConfig.TomcatCondition.class)
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat") // Conditional클래스를 직접 만듦 (Tomcat 이 있으면 True 를 반환 하므로 Tomcat 을 띄움)
public class TomcatWebServerConfig {
    
    // property 에서 설정한 contextPath 값을 주입 시켜 줌
    @Value("${contextPath}")
    String contextPath;

    @Bean("tomcatWebServerFactory")
    @ConditionalOnMissingBean   // Class Leven 에 등록 된 Bean 이 없더라면 해당 Bean 을 등록
    // class, method Level 에서도 설정 ==> 등록된 WebServer Bean 이 없다면 해당 Bean 을 등록 (다른 WebServer 등록 된 Bean 이 없다면 해당 Bean 을 WebServer 로 사용)
    // Springboot 에서 만들어져 있는 ConditionalBean 을 사용
    // public ServletWebServerFactory servletWebServerFactory(Environment env) {
    // Environment 객체를 사용할 필요 없으므로 파라미터로 넘겨 주지 않음
    public ServletWebServerFactory servletWebServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        // 모든 Request URL 앞에 app 을 붙여 사용하여야 함 ex) /hello 로 Mapping 되어 있는 Controller 에서 http://localhost:8080/app/hello 라고 사용을 하여야 함
        // 모든 Serverl URL 에 맨 앞에 /app 이 붙음
        // factory.setContextPath("/app");
        // 위에 처럼 하드코딩이 아닌 설정 해 둔 Property 값을 가져와서 값을 꽂아 줄 수 있도록 변경을 해 줌
        // String contextPath = env.getProperty("contextPath");

        System.out.println("설정 해 둔 ContextPath Property Value : " + contextPath);
        
        // Environment 에서 가져온 contextPath 값 말고 property 에서 값을 직접 주입 받은 contextPath 변수 값을 사용
        // factory.setContextPath(contextPath);
        factory.setContextPath(this.contextPath);   // value 에서 ${contextPath} 해당 변수가 들어가는 게 아니라 해당 값 자체가 들어가 오류가 발생 --> PropertyPlaceHolderConfig 를 사용하여 해당 에러 fix

        return factory;
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
