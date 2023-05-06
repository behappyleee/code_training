package com.study.toby_spring;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

// SpringBoot 가 제공하는 JDBC Test 어노테이션을 사용
// JdbcTest 어노테이션 사용 시 embeded DataSource Bean 으로 바꾸어 줌 (embeded DB 로 테스트 시 상당히 빠름)
@JdbcTest
public class DataSourceSpringBootTest {

    @Autowired
    DataSource dataSource;

    @Test
    void connect() throws SQLException {
        // DataSource Connection 을 잘 가져 오는 지
        Connection connection = dataSource.getConnection();
        // 연결이 안되었으면 위에서 에러를 발생 시키기에 Connection Close 시켜 버림
        connection.close();
    }

}
