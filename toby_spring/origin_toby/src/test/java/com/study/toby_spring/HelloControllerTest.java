package com.study.toby_spring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloControllerTest {

    // Controller 로직 테스트
    // HelloController 에서만 집중 하여 테스트를 희망
    // HelloService 와는 상관 없이 HelloController 만 고립하여 테스트를 진행
    // 각각 단위 테스트를 진행
    @Test
    void helloController() {
        // SpringContainer 상관 없이 순수 자바로 Test 진행
        // Test Stub 을 사용하여 진행
        // Dependency Injection 은 Runtime 시에 제 3자가 관계를 정의해 줌
        
        // HelloService 에 메서드가 1개에서 2개로 늘어나며서 람다식으로 사용이 안됨 (그래서 다른 메서드는 default 로 설정)
        HelloController helloController = new HelloController(name -> name);
        String res = helloController.hello("Test");
        Assertions.assertThat(res).isEqualTo("Test");
    }

    @Test
    void failHelloControllerTest() {
        HelloController helloController = new HelloController(name -> name);
        // 예외 테스트 이므로 예외가 발생하면 테스트 성공 정상적이면 테스트 실패라고 간주
        // NULL 검증 (Exception 발생하므로 테스트 성공)
        Assertions.assertThatThrownBy(()-> {
            String ret = helloController.hello(null);

        }).isInstanceOf(IllegalArgumentException.class);

        // 빈 문자열 체크 (Exception 발생하지 않으므로 테스트 실패)
        Assertions.assertThatThrownBy(()-> {
            String ret = helloController.hello(null);
        }).isInstanceOf(IllegalArgumentException.class);

    }

}
