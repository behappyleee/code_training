package com.study.toby_spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

// @RestController
@RestController
// 메타 어노테이션 -> 어노테이션 위에 붙은 어노테이션을 메타 어노테이션이라고 함
// @Component // Component 어노테이션으로 Spring Container 에 들어가는 컴포넌트라고 선언을 해버림
public class HelloController {

    private final HelloService helloService;  // 외부에 공개 할 필요 없음
    // 이 해당 변수는 final 로 만들 수 없음 적어도 final 이면 생성자에서 인스턴스를 생성해 주어야 하는 데
    // 해당 변수에 주입 시 setApplicationContext() 는 모든 인스턴스가 생성이 된 수 주입이 되어 final 키워드는 사용이 불가
    private final ApplicationContext applicationContext;

    public HelloController(HelloService helloService, ApplicationContext applicationContext) {
        this.helloService = helloService;
        this.applicationContext = applicationContext;
    }

    // Spring Annotation 을 제거 Spring 대신 순수 자바로 구현
    // View 를 Reeturn 하는 것이 아니므로 API 임
    // DispatcherServlet 이 가장 default Return 은 String return 시 view 를 찾음 String 문자열 자체가 return 이 아님
    // view 가 아니라는 것을 명시하기 위하여서는 ResponseBody 를 붙여주어야 함
    @GetMapping("/hello")
    public String hello(String name) {
        // 객체를 직접 생성 하기 보다는 Spring 에 기능인 DI 를 이용 (외부에서 생성 된 객체를 주입 받아 사용)
        // SimpleHelloService helloService = new SimpleHelloService();
        // requireNonNull 을 이용하여 Null 인 경우를 체크

        return helloService.sayHello(Objects.requireNonNull(name));
    }
    
    // 실행 될 떄 자동으로 실행이 됨
    // 생성자를 통하여 주입 받음 하여 applicationContext 변수 에 final 키워드 사용이 가능
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) {
//        System.out.println("APPLICATION CONTEXT TEST : " + applicationContext);
//        this.applicationContext = applicationContext;
//    }

}
