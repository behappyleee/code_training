package com.study.config.autoConfig;
import com.study.config.ConditionalMyOnClass;
import com.study.config.MyAutoConfiguration;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@MyAutoConfiguration
@ConditionalMyOnClass("org.springframework.bot.web.embedded.undertow.UndertowWebServer")
public class UndertowWebServerConfig {

    @Bean("undertowWebServer")
    public ServletWebServerFactory undertowWebServer() {
        return new UndertowServletWebServerFactory();
    }

}
