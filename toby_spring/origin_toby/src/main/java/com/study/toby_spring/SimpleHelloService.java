package com.study.toby_spring;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

// @Component
@Service   // 실제 로직이 수행 되는 Service 단 이므로 Service 어노테이션을 붙여 줌 어노테이션 안에 들어가 보면 Component 어노테이션이 있음
public class SimpleHelloService implements HelloService {

    private final HelloRepository helloRepository;
    
    // SimpleHelloService 는 이제 HelloRepositoryBean 에 의존 함
    public SimpleHelloService(HelloRepository helloRepository) {
        this.helloRepository = helloRepository;
    }

    @Override
    public String sayHello(String name) {
        this.helloRepository.increaseCount(name);
        return "This is SimpleHello Service Hello " + name;
    }

    @Override
    public int countOf(String name) {
        return helloRepository.countOf(name);
    }

}
