package com.study.toby_spring;

import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;

public class TobySpringApplication {

	// SpringBoot 가 처음 만들어 준 main 메서드를 실행 시 tomcat 이 자동 실행이 됨
	// 어떠한 설정도 하지 않음

	// 순수 main 메서드만 실행
	public static void main(String[] args) {
		System.out.println("Hello Containerless standalone Application !");
		// Tomcat 시작 클래스
		// 직접 시작하려면 복잡한 설정이 필요
		// new Tomcat().start();

		// Spring 에서는 톰캣을 시작할 수 있게 도와주는 클래스가 존재
		// Spring 은 모든 걸 추상화 하는 것을 좋아함
		ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
		WebServer webServer = serverFactory.getWebServer();	// WebServer 타입으로 받음 다른 WebServer 도 받을 수 있음
		webServer.start();	// TomcatServletContainer 가 동작을 함
	}

//	public static void main(String[] args) {
//		SpringApplication.run(TobySpringApplication.class, args);
//	}

}
