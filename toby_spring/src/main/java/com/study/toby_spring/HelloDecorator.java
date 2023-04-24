package com.study.toby_spring;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Primary    // SpringContainer 가 Autowired 가 주입 여러 개일 시 해당 클래스를 제일 Primary 로 주입이 됨
public class HelloDecorator implements HelloService {
    // DI 가 가능한 구조로 설계시 굉장 히 유연한 구조 설계가 가능
    
    // Decorator Design Pattern
    // 기존 의존 Object 에 동적으로 책임을 추가하여 줌
    
    // Proxy Pattern
    // 실제 가지고 있는 Object 가 비용이 많이 드는 Object 면 서버가 시작 될 떄 미리 만들어 놓을 필요는 없고
    // 실제 Request 가 있을 때 만드는 Object (Lazy Loading 이라고 함)
    // Proxy 는 실체가 존재 하지만 앞에 대신할 수 있는 것을 가져다 놓는 느낌으로 이해

    // HelloDecorator 클래스가 생기면서
    // HelloService 를 상속한 Class 가 SimpleHelloService 랑 HelloDecorator 2개 클래스가 존재 함
    // 만약 프로그램 시작 시 2개 클래스가 인터페이스를 상속 후 제대로 Autowired 를 해주지 않을 시 에러가 발생 함 !!

    // final keyword 붙은 변수는 초기에 초기화를 키져주지 않을 시 무조건 생성자에서 초기화를 시켜주어야 함 !
    private final HelloService helloService;

    public HelloDecorator(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public String sayHello(String name) {
        return "* " + helloService.sayHello(name) + " *";
    }

}
