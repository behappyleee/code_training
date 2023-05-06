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

    // Spring Container 는 Bean 에서 Interface 를 구현한 클래스를 먼저 스캔한 후
    // 만약 인터페이스를 구현을 한 클래스가 단 하나라면 그 클래스를 무주건 주입 시켜 줌 (단일 주입) - Autowiring
    // 하지만 Version Up 되어도 Autowired 어노테이션을 삭제해주어도 자동으로 주입 시켜 줌
    
    // HelloService 에 의존 하게 됨, HelloService 를 구현한 클래스를 유연하게 바꾸어 가면 서 적용이 가능
    private final HelloService helloService;  // 외부에 공개 할 필요 없음
    // 이 해당 변수는 final 로 만들 수 없음 적어도 final 이면 생성자에서 인스턴스를 생성해 주어야 하는 데
    // 해당 변수에 주입 시 setApplicationContext() 는 모든 인스턴스가 생성이 된 수 주입이 되어 final 키워드는 사용이 불가
    // private final ApplicationContext applicationContext;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

//    public HelloController(HelloService helloService, ApplicationContext applicationContext) {
//        this.helloService = helloService;
//        this.applicationContext = applicationContext;
//    }

    // Spring Annotation 을 제거 Spring 대신 순수 자바로 구현
    // View 를 Reeturn 하는 것이 아니므로 API 임
    // DispatcherServlet 이 가장 default Return 은 String return 시 view 를 찾음 String 문자열 자체가 return 이 아님
    // view 가 아니라는 것을 명시하기 위하여서는 ResponseBody 를 붙여주어야 함
    @GetMapping("/hello")
    public String hello(String name) {
        // 객체를 직접 생성 하기 보다는 Spring 에 기능인 DI 를 이용 (외부에서 생성 된 객체를 주입 받아 사용)
        // SimpleHelloService helloService = new SimpleHelloService();
        // requireNonNull 을 이용하여 Null 인 경우를 체크

        // Object.requireNonNull 은 NULL 만 체크하고 공백은 체크를 못해주므로 코드 수정
        if(name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException();
        }
        return helloService.sayHello(name);
        // return helloService.sayHello(Objects.requireNonNull(name));
    }
    
    // 실행 될 떄 자동으로 실행이 됨
    // 생성자를 통하여 주입 받음 하여 applicationContext 변수 에 final 키워드 사용이 가능
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) {
//        System.out.println("APPLICATION CONTEXT TEST : " + applicationContext);
//        this.applicationContext = applicationContext;
//    }

    @GetMapping("/count")
    public String getCount(String name) {
        return  name + " : " + helloService.countOf(name);
    }

}
