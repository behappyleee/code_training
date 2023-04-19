package com.study.toby_spring;

import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.HttpRetryException;

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
			// SpringContainer 를 직접 구현
			GenericApplicationContext applicationContext = new GenericApplicationContext();
			//Bean 을 등록 (Class 정보를 넘겨 줌)
			applicationContext.registerBean(HelloController.class);
			applicationContext.refresh();	// 자기가 가진 구성정보를 이용하기 위하여 초기화
			// 계속 객체를 생성할 필요 없으므로 한번만 객체 생성하여 리턴
			// HelloController helloController = new HelloController();
			
			// FrontController 생성
			servletContext.addServlet("frontController", new HttpServlet()  {
				@Override
				protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
					// 인증, 보안, 다국어, 공통 기능 들을 보통 처리
					// ServletConstainer 에 Mapping 기능을 담당 FrontController 가 담당
					// Mapping 들을 처리해 줌 ! (URL 이 /test 이면서 HTTP Get 방식일 떄 Mapping 이 됨)
					// Mapping 은 Request 에서 어떤 요청을 할 시 어떻게 처리할 건지를 결정
					if(req.getRequestURI().equals("/test") && req.getMethod().equals(HttpMethod.GET.name())) {
						String name = req.getParameter("name");
						// 웹 요청을 가지고 사용할 수 있게 변환을 해주는 것을 파라미터로 넘겨주는 것 을 Binding 이라고 함

						// String returnValue = helloController.hello(name);
						// 모든 Bean 에는 이름이 있음
						HelloController helloController = applicationContext.getBean(HelloController.class);
						String returnValue = helloController.hello(name);

						// res.setStatus(HttpStatus.OK.value());	// 사실 생략을 해도 괜찮음 Servlet 에서 Return 정상일 시 200 값을 자동으로 셋팅을 해줌
						// res.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);    // Header 를 text/plain 으로 설정
						res.setContentType(MediaType.TEXT_PLAIN_VALUE);	// 위에 setHeader 를 이렇게 한 줄로 처리가 가능 !
						// Body 는 양이 많기에 Writer 객체를 이용하여 사용
						res.getWriter().println("Hello Test !! : " + returnValue);
					} else {
						res.setStatus(HttpStatus.NOT_FOUND.value());
					}
				}
				// FrontController 는 모든 요청을 받아야 하기에 아래처럼 URL 경로를 설정
			}).addMapping("/*");

			// Interface 이기에 익명 클래스를 생성 해줌 (인터페이스라 바로 사용이 안됨)
			// ServletContextInitializer 는 FunctionalInterface 로 람다식으로 사용이 가능
			// 두번쨰 파라미터로 HttpServlet을 넘겨줌
			// Servlet 추가 시 또 필요한 사항은 요청을 어떤 서블릿에 연결해 줄 지를 설정 해 주어야 함
			// Servlet Name 을 지정 해줌
			servletContext.addServlet("hello", new HttpServlet() {
				@Override
				protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
					// Parameter 로 넘어 올 때 (Name 을 파라미터로 넘겨 줄 때 받음)
					String name = req.getParameter("name");

					res.setStatus(HttpStatus.OK.value());
					res.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);    // Header 를 text/plain 으로 설정
					// Body 는 양이 많기에 Writer 객체를 이용하여 사용
					res.getWriter().println("Hello Servlet !! : " + name);
				}
				// /hello 주소에 Mapping을 시켜 줌
			}).addMapping("/hello");
		});    // WebServer 타입으로 받음 다른 WebServer 도 받을 수 있음
		webServer.start();    // TomcatServletContainer 가 동작을 함
	}

//	public static void main(String[] args) {
//		SpringApplication.run(TobySpringApplication.class, args);
//	}

}
