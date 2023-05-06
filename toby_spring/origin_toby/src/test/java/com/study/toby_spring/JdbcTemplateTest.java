package com.study.toby_spring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;

// 커스텀하여 생성한 어노테이션 사용
@HelloBootTest
// 아래 rollback 어노테이션은 HelloBootTest 어노테이션에 이미 Transcational 어노테이션이 있어 rollback 이 자동적으로 되지만 테스트를 위하여 rollback(false) 어노테이션을 붙여 줌
// @Rollback(false)    // 강제로 Test 시에 rollback 하지 않도록 강제 시켜 버림 (데이터가 그냥 DB 에 저장 되어 버림)
public class JdbcTemplateTest {

    @Autowired
    JdbcTemplate jdbcTemplate;
    
    // BeforeEach 는 매 테스트 마다 이전에 한번씩 수행을 함
    // 테스트 하기전에 DB 를 초기화 해줌 내장형 DB 는 보통 어플리케이션 시작할 때 초기화 DB 됨
    // 그래서 시작때 아무런 데이터가 없는 DB 로 시작이 됨
    @BeforeEach
    void init() {
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS hello" +
                "(name varchar(50) primary key, count int)");
    }

    @Test
    void insertAndQuery() {
        jdbcTemplate.update("INSERT INTO hello values(? ,?)"
        , "Toby", 3);

        jdbcTemplate.update("INSERT INTO hello values(? ,?)"
        , "Lee", 5);

        jdbcTemplate.update("INSERT INTO hello values(? ,?)"
                , "Spring", 1);

        Long count = jdbcTemplate.queryForObject("SELECT count(*) FROM hello",
                Long.class);

        Assertions.assertThat(count).isEqualTo(3);

    }

    // 만약 Transaction 이 되지 않았더라면 Test 데이터도 db 에 저장 되기에 아래 테스트는 fail 남 (데이터가 저장 되기에 데이터 갯수가 6개가 됨)
    // 지금 사용하고 있는 db 는 h2 MEMORY DB 이기에 Runtime 시에만 db 가 작동을 함 (Application 실행 시 마다 db 초기화 됨)
    @Test
    void insertAndQuery2() {
        jdbcTemplate.update("INSERT INTO hello values(? ,?)"
                , "Toby2", 3);

        jdbcTemplate.update("INSERT INTO hello values(? ,?)"
                , "Lee2", 5);

        jdbcTemplate.update("INSERT INTO hello values(? ,?)"
                , "Spring2", 1);

        Long count = jdbcTemplate.queryForObject("SELECT count(*) FROM hello",
                Long.class);

        Assertions.assertThat(count).isEqualTo(3);
    }

}
