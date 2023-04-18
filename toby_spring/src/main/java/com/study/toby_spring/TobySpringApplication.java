package com.study.toby_spring;

import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TobySpringApplication {

	// SpringBoot 가 처음 만들어 준 main 메서드를 실행 시 tomcat 이 자동 실행이 됨
	// 어떠한 설정도 하지 않음

	// Spring MVC 에서 제일 중요한 것은 Request 가 어떻게 Mapping 되는 지 파악하는 것이 가장 중요

	// 순수 main 메서드만 실행
	public static void main(String[] args) {
		System.out.println("Hello Containerless standalone Application !");
		// Tomcat 시작 클래스
		// 직접 시작하려면 복잡한 설정이 필요
		// new Tomcat().start();

		// Spring 에서는 톰캣을 시작할 수 있게 도와주는 클래스가 존재
		// Spring 은 모든 걸 추상화 하는 것을 좋아함
		ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
		
		// Parameter 로 ServletContextInitailizer 를 넣어줌
		// 익명 클래스를 생성하는 것과 파라미터로 넘겨주는 것은 똑같음
		WebServer webServer = serverFactory.getWebServer(servletContext -> {
			// Interface 이기에 익명 클래스를 생성 해줌 (인터페이스라 바로 사용이 안됨)
			// ServletContextInitializer 는 FunctionalInterface 로 람다식으로 사용이 가능
			// 두번쨰 파라미터로 HttpServlet을 넘겨줌
			// Servlet 추가 시 또 필요한 사항은 요청을 어떤 서블릿에 연결해 줄 지를 설정 해 주어야 함
			// Servlet Name 을 지정 해줌
			servletContext.addServlet("hello", new HttpServlet() {
				@Override
				protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
					res.setStatus(200);
					res.setHeader("Content Type", "text/plain");	// Header 를 text/plain 으로 설정
					// Body 는 양이 많기에 Writer 객체를 이용하여 사용
					res.getWriter().println("Hello Servlet !!");
				}
				// /hello 주소에 Mapping을 시켜 줌
			}).addMapping("/hello");
		});	// WebServer 타입으로 받음 다른 WebServer 도 받을 수 있음

		webServer.start();	// TomcatServletContainer 가 동작을 함
	}

//	public static void main(String[] args) {
//		SpringApplication.run(TobySpringApplication.class, args);
//	}

}
