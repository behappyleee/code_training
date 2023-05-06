package com.study.toby_spring;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


// 커스텀하여 생성한 어노테이션 사용
@HelloBootTest  //  Transactional 어노테이션이 있어 테스트가 끝나면 db 를 Rollback 시켜 줌
// 계속하여 어노테이션이 붙을꺼기 때문에 따로 어노테이션을 뺴버림 HelloBootTest 로 어노테이션으로 뺴버림
//@ExtendWith(SpringExtension.class)  // SpringExtensiotn 을 사용 시 SpringContext 를 이용하여 SpringContainer 테스트가 가능
//@ContextConfiguration(classes = TobySpringApplication.class)    // Bean 들을 Loading 할 정보를 가져옴 모든 Bean 구정 정보를 끌어옴
//// 아래 어노테이션을 추가해 주어야 application.properties 설정을 가져옴 application.properties 는 springboot 초기화 과정에서 프로퍼티 값을을 가져와 줌
//@TestPropertySource("classpath:/application.properties")    // 외부 설정을 application.properties 등록은 springboot 초기화 과정에서 추가하여 자동으로 추가가 아노딤
//// 아래 어노테이션은 Transaction 안에 서 동작을 하고 Test 가 끝나고 나면 rollback 을 하도록 설정, 조작 된 db 다시 rollback 시켜 줌 (제일 좋은 상태는 TestCalss 전체에 Transcational 어노테이션을 붙여줌)
//@Transactional  // 해당 어노테이션은 DataBase 테스트시에 많이 붙임, 만약 테스트 후에도 저장된 데이터가 남지 않도록 rollback 을 해줌
public class DataSourceTest {

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
