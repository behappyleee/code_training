package com.study.config.autoConfig;

import com.study.config.MyConfigurationProperties;
import org.springframework.stereotype.Component;

@Component  // 1. ComponentScanner 에 의하여 2. import 방법 ===> 2가지 방법 중 1 개로 Bean 으로 등록이 됨
@MyConfigurationProperties(prefix = "server")   // Property 값을 구분 하기 위하여 prefix 를 사용
public class ServerProperties {
    private String contextPath;
    private int port;

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

}
