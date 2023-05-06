package com.study.toby_spring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class HelloServiceCountSpringBootTest {

    // 해당 Test 에서 @PostConsturction 어노테이션을 사용하여
    // Application 실행 준비를 마치면 자동으로 테이블으 실행하게 만들어 주어 테스트가 가능하도록 해 줌

    @Autowired
    HelloService helloService;

    @Autowired
    HelloRepository helloRepository;

    @Test
    void sayHelloIncreaseCount() {
        IntStream.rangeClosed(1, 10).forEach(count -> {
            // 테스트 위에파일 까지 한꺼번에 돌릴 시 해당 Test 는 Fail 발생 함 (위에 실행 한 내역이 저장 되기에)
            // Transactional 어노테이션을 붙여주지 않을 시 데이터 롤백이 안됨
            helloService.sayHello("Toby");
            Assertions.assertThat(helloRepository.countOf("Toby")).isEqualTo(count);
        });
    }

}
