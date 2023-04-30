package com.study.config.autoConfig;

import com.study.config.MyAutoConfiguration;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@MyAutoConfiguration
public class ServerPropertiesConfig {

    // 조금 더 편리한 방법을 찾아 보도록 함
//    @Bean
//    public ServerProperties serverProperties(Environment env) {
////        ServerProperties serverProperties = new ServerProperties();
////
////        serverProperties.setContextPath(env.getProperty("contextPath"));
////        serverProperties.setPort(Integer.parseInt(env.getProperty("port")));    // application.properties 에 설정해둔 값 가져옴
////
////        return serverProperties;
//
//    // Binder 라는 객체를 사용 시 위에 처럼 일일이 set 해 줄 필요 없이 Property 명에 맞는 것에 값이 알아서 Binding 이 됨
//        return Binder.get(env).bind("",ServerProperties.class).get();
//    }

}
