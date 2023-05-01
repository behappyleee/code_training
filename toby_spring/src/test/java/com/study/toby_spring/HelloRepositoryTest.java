package com.study.toby_spring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@HelloBootTest
public class HelloRepositoryTest {
    // TODO
    // TEST 필요
    // No DatSource Set Error 가 발생함
    // 확인이 필요 (DataSourceSet 이 안됨 Test Error 가 발생하여 확인이 필요 !)

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    HelloRepository helloRepository;

    @BeforeEach
    void init() {
        jdbcTemplate.execute(
                "CREATE TABLE IF NOT EXISTS hello(name varchar(50) PRIMARY KEY, count int)"
        );
    }

    // findHello 를 하였을 때 해당하는 레코드가 없을 때 어떻게 동작하는 지 확인
    @Test
    void findHelloFailed() {
        // findHello 메서드 사용시 데이터가 하나도 존재하지 않다면 Exception 을 던져 버림 (예외를 던져 버림)
        // Hello 테스트 Fail 시키기 (데이터를 넣지 않았기에 Fail 됨 들어있는 데이터는 없음)
        Assertions.assertThat(helloRepository.findHello("Toby")).isNull();
    }

}
