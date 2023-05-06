package com.study.toby_spring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface fastUnitTest1 {

}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE , ElementType.METHOD})
@Test   // Meta Annotation 부여
@interface UnitTest1 {
}

// SpringBoot 는 Test를 진행할 시 모든 Bean Container 을 띄우는데 이 테스트를 실행할 시에는 모든 Bean 들을 띄울 필요 없음 WEB 환경을 셋팅할 필요는 없음
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class HelloServiceSpringBootTest {


    // HelloApiTest 는
    // 서버를 먼저 띄워두고 Http 를 통하여 송신을 하였지만 Service 를 바로 띄워 테스트르 진행 시 바로 테스트가 가능
    // 테스트 성능이 훨씬 빠르고 독립적인 테스팅이 가능
    @Test
    void simpleHelloService() {
//        SimpleHelloService helloService = new SimpleHelloService(new HelloRepository() {
//            @Override
//            public Hello findHello(String name) {
//                return null;
//            }
//
//            @Override
//            public void increaseCount(String name) {
//
//            }
//        });

        // 위에 익명클래스가 소스가 지저분 하다면 따로 메서드로 뺴서 사용
        SimpleHelloService helloService = new SimpleHelloService(getHelloRepository());

        String res = helloService.sayHello("Test");
        Assertions.assertThat(res).isEqualTo("This is SimpleHello Service Hello Test");
    }

    @Test
    void helloDecorator() {
        HelloDecorator decorator = new HelloDecorator(name -> name);

        String res = decorator.sayHello("Test");
        Assertions.assertThat(res).isEqualTo("* Test *");
    }

    private static HelloRepository helloRepositoryStub = new HelloRepository() {
        @Override
        public Hello findHello(String name) {
            return null;
        }
        @Override
        public void increaseCount(String name) {

        }
    };

    public HelloRepository getHelloRepository() {
        // 익명 클래스로 바로 구현하여 HelloRepository 객체를 바로 리턴
        HelloRepository helloRepository = new HelloRepository() {
            @Override
            public Hello findHello(String name) {
                return null;
            }
            @Override
            public void increaseCount(String name) {

            }
        };
        return helloRepository;
    }

}
