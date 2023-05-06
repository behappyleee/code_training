package com.study.toby_spring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.stream.IntStream;

@HelloBootTest
public class HelloServiceCountCheck {

    // 해당 Test 에서 @PostConsturction 어노테이션을 사용하여
    // Application 실행 준비를 마치면 자동으로 테이블으 실행하게 만들어 주어 테스트가 가능하도록 해 줌

    @Autowired
    HelloService helloService;

    @Autowired
    HelloRepository helloRepository;

    @Test
    void sayHelloIncreaseCount() {
        IntStream.rangeClosed(1, 10).forEach(count -> {
            helloService.sayHello("Toby");
            Assertions.assertThat(helloRepository.countOf("Toby")).isEqualTo(count);
        });
    }
}
