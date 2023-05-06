package com.study.toby_spring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface fastUnitTest {

}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE , ElementType.METHOD})
@Test   // Meta Annotation 부여
@interface UnitTest {
}

public class HelloServiceTest {
    
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
