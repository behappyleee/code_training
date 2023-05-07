package com.my.study_toby.config.autoConfig;

import org.springframework.stereotype.Component;

@Component
public class ServerProperties {

    private String contextPath;
    private int port;

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }
    public String getContextPath() {
        return contextPath;
    }
    public void setPort(int port) {
        this.port = port;
    }
    public int getPort() {
        return port;
    }

}
