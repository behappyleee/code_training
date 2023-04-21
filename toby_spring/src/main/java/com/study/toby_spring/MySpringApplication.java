package com.study.toby_spring;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MySpringApplication {
    public static void run(Class<?> applicationClass, String... args) {
        AnnotationConfigWebApplicationContext applicationContext = onRefresh () -> {
            super.onRefresh();

            ServletWebServerFactory = 


        }


//        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
//            // ServletContainer 안에서 모든 관리를 하도록 변경을 함
//            @Override
//            protected void onRefresh() {
//                super.onRefresh();
//                // 객체는 2개 생성이 됨 TomcatServletWebServerFactory() 와 DispatcherServlet() 임
//                // 2개 도 Bean 으로 등록이 됨 (Bean 으로 등록 시 상당한 유연한 동작이 가능함)
//                // ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
//                // Spring 프레임워크레 등록되어 있는 Bean 에 클래스를 가져옴 !
//
//                // Bean 에 등록되어 있는 객체를 가져올 시 다음과 같이 사용
//                ServletWebServerFactory serverFactory = this.getBean(ServletWebServerFactory.class);
//                DispatcherServlet dispatcherServlet = this.getBean(DispatcherServlet.class);
//
//                // 해당 set을 안하여도 dispatcherServlet 은 ApplicationContextAware 에 의하여 자동으로 주입이 됨
//                dispatcherServlet.setApplicationContext(this);    // Spring Container 를 지정해 줌, Factory Method 를 이용하여 2개를 등록
//
//                WebServer webServer = serverFactory.getWebServer(servletContext -> {
//                    // Servlet 을 직접 만드는 것 보다 dispatcherServlet 을 사용 (DispatcherServlet 은 알아서 모든 걸 다 해줌)
//                    // Dispatcher Servlet 이 Bean 을 다 뒤짐, Bean 을 다뒤져서 Mapping 되어 있는 정보를 찾음
//                    servletContext.addServlet("dispatcherServlet", dispatcherServlet)
//                            // 요청 정보를 Controller 클래스 안에 Mapping 정보를 넣는 것이 가장 인기 많았음
//                            .addMapping("/*");
//                });
//                webServer.start();
//            }
//        };
//
//        applicationContext.register(applicationClass);
//        applicationContext.register();
    }

}
