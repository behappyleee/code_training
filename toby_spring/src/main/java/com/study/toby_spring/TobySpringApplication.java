package com.study.toby_spring;

import com.study.config.MySpringAnnotation;
import org.springframework.boot.SpringApplication;

// @Configuration	// Config 정보를 가지고 있는 클래스라고 인식 (Config 어노테이션이 붙은 클래스는 Bean 이 존재한다고 인식)
// Component 스캔이 직관적이므로 사용하기 쉬움
// @ComponentScan	// Component 어노테이션이 붙은 클래스들을 찾아서 Bean 으로 등록을 해줌
@MySpringAnnotation    // @Configuration / @Componet Annotation 을 등록 (Meta Annotation 개념으로)
public class TobySpringApplication {
	// 2개의 Bean Spring 에 Bean 을 등록
	// Bean 을 Config 클래스로 뺴 줌

	// 자동 구성 후보 Loading
	// Conditional Class 조건 체크 -> @Conditional @Bean 조건 체크
	// 커스텀 @Bean 구성 정보 -> MyAutoConfiguration @Bean 구성 정보

	// SpringFramework 에서 제공 하는

//	@Bean
//	public ServletWebServerFactory servletWebServerFactory() {
//		return new TomcatServletWebServerFactory();
//	}
//
//	@Bean
//	public DispatcherServlet dispatcherServlet() {
//		return new DispatcherServlet();
//	}

	// Spring 프레임워크에 Bean 을 등록
	// Bean 어노테이션은 Spring에 Component 로 인식
	// Java 로 Bean 을 등록 해주지 않을 시 어노테이션을 @Component 를 붙여 줌 !
//	@Bean
//	public HelloController helloController(HelloService helloService) {
//		return new HelloController(helloService);
//	}
//
//	// FactoryMethod Pattern 은 어떤 타입을 Return 을 받을 지 결정
//	@Bean
//	public HelloService helloService() {
//		return new SimpleHelloService();
//	}

	// SpringBoot 가 처음 만들어 준 main 메서드를 실행 시 tomcat 이 자동 실행이 됨
	// 어떠한 설정도 하지 않음

	// Spring MVC 에서 제일 중요한 것은 Request 가 어떻게 Mapping 되는 지 파악하는 것이 가장 중요
	// 순수 main 메서드만 실행
	public static void main(String[] args) {
		System.out.println("Hello Containerless standalone Application !");
		// Tomcat 시작 클래스
		// 직접 시작하려면 복잡한 설정이 필요
		// new Tomcat().start();

		// 해당 아래 내역은 method run() 으로 따로 뺴 줌
		// 초창기 Springboot run 메서드랑 상당히 흡사함
		SpringApplication.run(TobySpringApplication.class, args);

//		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
//			// ServletContainer 안에서 모든 관리를 하도록 변경을 함
//			@Override
//			protected void onRefresh() {
//				super.onRefresh();
//				// 객체는 2개 생성이 됨 TomcatServletWebServerFactory() 와 DispatcherServlet() 임
//				// 2개 도 Bean 으로 등록이 됨 (Bean 으로 등록 시 상당한 유연한 동작이 가능함)
//				// ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
//				// Spring 프레임워크레 등록되어 있는 Bean 에 클래스를 가져옴 !
//
//				// Bean 에 등록되어 있는 객체를 가져올 시 다음과 같이 사용
//				ServletWebServerFactory serverFactory = this.getBean(ServletWebServerFactory.class);
//				DispatcherServlet dispatcherServlet = this.getBean(DispatcherServlet.class);
//
//				// 해당 set을 안하여도 dispatcherServlet 은 ApplicationContextAware 에 의하여 자동으로 주입이 됨
//				dispatcherServlet.setApplicationContext(this);	// Spring Container 를 지정해 줌, Factory Method 를 이용하여 2개를 등록
//
//				WebServer webServer = serverFactory.getWebServer(servletContext -> {
//					// Servlet 을 직접 만드는 것 보다 dispatcherServlet 을 사용 (DispatcherServlet 은 알아서 모든 걸 다 해줌)
//					// Dispatcher Servlet 이 Bean 을 다 뒤짐, Bean 을 다뒤져서 Mapping 되어 있는 정보를 찾음
//					servletContext.addServlet("dispatcherServlet", dispatcherServlet)
//							// 요청 정보를 Controller 클래스 안에 Mapping 정보를 넣는 것이 가장 인기 많았음
//					.addMapping("/*");
//				});
//				webServer.start();
//			}
//		};

		// 해당 register 입력 시 자바로 된 구성정보가 있으니 여기서부터 시작하라는 의미
//		applicationContext.register(TobySpringApplication.class);
		// refresh 는 전형적인 초기화임 template Method 안에서 일정한 작업이 수행이 됨
//		applicationContext.refresh();		// 자기가 가진 구성정보를 이용하기 위하여 초기화

//		applicationContext.registerBean(HelloController.class);
//		applicationContext.registerBean(SimpleHelloService.class);	// Interface 는 안됨, HelloSerivce 를 구현한 클래스를 찾음 --> Controller 에서 파라미터로 전달
//		// refresh 는 전형적인 초기화임 template Method 안에서 일정한 작업이 수행이 됨
//		applicationContext.refresh();		// 자기가 가진 구성정보를 이용하기 위하여 초기화

		// Spring 에서는 톰캣을 시작할 수 있게 도와주는 클래스가 존재
		// Spring 은 모든 걸 추상화 하는 것을 좋아함
//		ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
//
//		// Parameter 로 ServletContextInitailizer 를 넣어줌
//		// 익명 클래스를 생성하는 것과 파라미터로 넘겨주는 것은 똑같음
//		WebServer webServer = serverFactory.getWebServer(servletContext -> {
//			// Servlet 을 직접 만드는 것 보다 dispatcherServlet 을 사용 (DispatcherServlet 은 알아서 모든 걸 다 해줌)
//			// Dispatcher Servlet 이 Bean 을 다 뒤짐, Bean 을 다뒤져서 Mapping 되어 있는 정보를 찾음
//			servletContext.addServlet("dispatcherServlet", new DispatcherServlet(applicationContext)
//				// 요청 정보를 Controller 클래스 안에 Mapping 정보를 넣는 것이 가장 인기 많았음
//			).addMapping("/*");
//
//			// Servlet 을 직접 만들어보는 실습을 진행하였음 !
//			// SpringContainer 를 직접 구현
////			GenericApplicationContext applicationContext = new GenericApplicationContext();
////			// Bean 을 등록 (Class 정보를 넘겨 줌)
////			applicationContext.registerBean(HelloController.class);
////			applicationContext.registerBean(SimpleHelloService.class);	// Interface 는 안됨, HelloSerivce 를 구현한 클래스를 찾음 --> Controller 에서 파라미터로 전달
////			applicationContext.refresh();	// 자기가 가진 구성정보를 이용하기 위하여 초기화
////			// 계속 객체를 생성할 필요 없으므로 한번만 객체 생성하여 리턴
////			// HelloController helloController = new HelloController();
////
////			// FrontController 생성
////			servletContext.addServlet("frontController", new HttpServlet()  {
////
////				@Override
////				protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
////					// 인증, 보안, 다국어, 공통 기능 들을 보통 처리
////					// ServletConstainer 에 Mapping 기능을 담당 FrontController 가 담당
////					// Mapping 들을 처리해 줌 ! (URL 이 /test 이면서 HTTP Get 방식일 떄 Mapping 이 됨)
////					// Mapping 은 Request 에서 어떤 요청을 할 시 어떻게 처리할 건지를 결정
////					if(req.getRequestURI().equals("/test") && req.getMethod().equals(HttpMethod.GET.name())) {
////						String name = req.getParameter("name");
////						// 웹 요청을 가지고 사용할 수 있게 변환을 해주는 것을 파라미터로 넘겨주는 것 을 Binding 이라고 함
////
////						// String returnValue = helloController.hello(name);
////						// 모든 Bean 에는 이름이 있음
////						HelloController helloController = applicationContext.getBean(HelloController.class);
////						String returnValue = helloController.hello(name);
////
////						// res.setStatus(HttpStatus.OK.value());	// 사실 생략을 해도 괜찮음 Servlet 에서 Return 정상일 시 200 값을 자동으로 셋팅을 해줌
////						// res.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);    // Header 를 text/plain 으로 설정
////						res.setContentType(MediaType.TEXT_PLAIN_VALUE);	// 위에 setHeader 를 이렇게 한 줄로 처리가 가능 !
////						// Body 는 양이 많기에 Writer 객체를 이용하여 사용
////						res.getWriter().println("Hello Test !! : " + returnValue);
////					} else {
////						res.setStatus(HttpStatus.NOT_FOUND.value());
////					}
////				}
////				// FrontController 는 모든 요청을 받아야 하기에 아래처럼 URL 경로를 설정
////			}).addMapping("/*");
////			// Interface 이기에 익명 클래스를 생성 해줌 (인터페이스라 바로 사용이 안됨)
////			// ServletContextInitializer 는 FunctionalInterface 로 람다식으로 사용이 가능
////			// 두번쨰 파라미터로 HttpServlet을 넘겨줌
////			// Servlet 추가 시 또 필요한 사항은 요청을 어떤 서블릿에 연결해 줄 지를 설정 해 주어야 함
////			// Servlet Name 을 지정 해줌
////			servletContext.addServlet("hello", new HttpServlet() {
////				@Override
////				protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
////					// Parameter 로 넘어 올 때 (Name 을 파라미터로 넘겨 줄 때 받음)
////					String name = req.getParameter("name");
////
////					res.setStatus(HttpStatus.OK.value());
////					res.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);    // Header 를 text/plain 으로 설정
////					// Body 는 양이 많기에 Writer 객체를 이용하여 사용
////					res.getWriter().println("Hello Servlet !! : " + name);
////				}
////				// /hello 주소에 Mapping을 시켜 줌
////			}).addMapping("/hello");
//
//		});    // WebServer 타입으로 받음 다른 WebServer 도 받을 수 있음
//
//
//		webServer.start();    // TomcatServletContainer 가 동작을 함
//	}

//	public static void main(String[] args) {
//		SpringApplication.run(TobySpringApplication.class, args);
//	}
//	}


	// MySpringApplication Class 로 해당 메서드로 옮김 !
//	private static void run(Class<?> applicationClass, String... args) {
//		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
//			// ServletContainer 안에서 모든 관리를 하도록 변경을 함
//			@Override
//			protected void onRefresh() {
//				super.onRefresh();
//				// 객체는 2개 생성이 됨 TomcatServletWebServerFactory() 와 DispatcherServlet() 임
//				// 2개 도 Bean 으로 등록이 됨 (Bean 으로 등록 시 상당한 유연한 동작이 가능함)
//				// ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
//				// Spring 프레임워크레 등록되어 있는 Bean 에 클래스를 가져옴 !
//
//				// Bean 에 등록되어 있는 객체를 가져올 시 다음과 같이 사용
//				ServletWebServerFactory serverFactory = this.getBean(ServletWebServerFactory.class);
//				DispatcherServlet dispatcherServlet = this.getBean(DispatcherServlet.class);
//
//				// 해당 set을 안하여도 dispatcherServlet 은 ApplicationContextAware 에 의하여 자동으로 주입이 됨
//				dispatcherServlet.setApplicationContext(this);    // Spring Container 를 지정해 줌, Factory Method 를 이용하여 2개를 등록
//
//				WebServer webServer = serverFactory.getWebServer(servletContext -> {
//					// Servlet 을 직접 만드는 것 보다 dispatcherServlet 을 사용 (DispatcherServlet 은 알아서 모든 걸 다 해줌)
//					// Dispatcher Servlet 이 Bean 을 다 뒤짐, Bean 을 다뒤져서 Mapping 되어 있는 정보를 찾음
//					servletContext.addServlet("dispatcherServlet", dispatcherServlet)
//							// 요청 정보를 Controller 클래스 안에 Mapping 정보를 넣는 것이 가장 인기 많았음
//							.addMapping("/*");
//				});
//				webServer.start();
//			}
//		};
//
//		applicationContext.register(applicationClass);
//		applicationContext.register();

	}

}

