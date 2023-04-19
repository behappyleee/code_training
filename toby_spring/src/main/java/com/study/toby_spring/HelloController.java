package com.study.toby_spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

// @RestController
public class HelloController {

    // Spring Annotation 을 제거 Spring 대신 순수 자바로 구현
    // View 를 Reeturn 하는 것이 아니므로 API 임
    // @GetMapping("/hello")
    public String hello(String name) {
        SimpleHelloService helloService = new SimpleHelloService();
        
        // requireNonNull 을 이용하여 Null 인 경우를 체크
        return helloService.sayHello(Objects.requireNonNull(name));
    }

}
