package com.study.toby_spring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloServiceTest {
    
    // HelloApiTest 는
    // 서버를 먼저 띄워두고 Http 를 통하여 송신을 하였지만 Service 를 바로 띄워 테스트르 진행 시 바로 테스트가 가능
    // 테스트 성능이 훨씬 빠르고 독립적인 테스팅이 가능
    @Test
    void simpleHelloService() {
        SimpleHelloService helloService = new SimpleHelloService();

        String res = helloService.sayHello("Test");
        Assertions.assertThat(res).isEqualTo("This is SimpleHello Service Hello Test");

    }

    @Test
    void helloDecorator() {
        HelloDecorator decorator = new HelloDecorator(name -> name);
        String res = decorator.sayHello("Test");

        Assertions.assertThat(res).isEqualTo("* Test *");
    }

}
