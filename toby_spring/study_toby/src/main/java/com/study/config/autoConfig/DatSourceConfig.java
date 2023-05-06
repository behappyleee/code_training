package com.study.config.autoConfig;

import com.study.config.ConditionalMyOnClass;
import com.study.config.EnableMyConfigurationProperties;
import com.study.config.MyAutoConfiguration;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.Driver;

// 아래 어노테이션 사용 시 Bean 으로 생성이 됨 (imports 파일에서 Bean 으로 지정을 해 줌)
@MyAutoConfiguration
// 아래 어노테이션 사용 시 아래 Class 객체가 존재 시 해당 COnfig 사용이 가능
@ConditionalMyOnClass("org.springframework.jdbc.core.JdbcOperations")
// 아래 어노테이션 사용 시 Properties 값들이 주입을 받을 수 있음
@EnableMyConfigurationProperties(MyDataSourceProperties.class)
@EnableTransactionManagement    // Transactional 어노테이션을 사용할 수 있게 해 줌
public class DatSourceConfig {
    // Bean 메서드는 순서대로 실행 처음에 HikariDataSource Bean 이 없을 때 밑에 SimpleDataSource 를 Bena 으로 등록하여 사용하도록 수정

    // Hikari DataSource 설정 (SimpleDriverDataSource 말고 HikarDataSource 사용하도록 변경)
    @Bean
    // HikariDataSourceBean 이 있으면 해당 Bean 을 만들고 HikariDataSource 가 존재하지 않을 시 해당 Bean 을 만들지 않음
    @ConditionalMyOnClass("com.zaxxer.hikari.HikariDataSource")
    // 해당 아래 어노테이션 을 붙여 줄 시 DataSource Bean 을 만들어 지지 않을 시 해당 Bean 생성
    @ConditionalOnMissingBean
    DataSource hikariDataSource(MyDataSourceProperties properties) throws ClassNotFoundException {
        HikariDataSource dataSource = new HikariDataSource();
        // Hikari DataSource 는 driverClassName 그냥 문자열로 주면 알아서 변환함
        // dataSource.setDriverClassName((Class<? extends Driver>) Class.forName(properties.getDriverClassName()));
        dataSource.setDriverClassName(properties.getDriverClassName());
        // Hikar Datasource 에서 URL 은 조금 더 명확하게 jdbcUrl 로 변경
        dataSource.setJdbcUrl(properties.getUrl());
        dataSource.setUsername(properties.getUserName());
        dataSource.setPassword(properties.getPassword());

        return dataSource;
    }

    // DataSourceConifg 설정 Bean
    @Bean
    @ConditionalOnMissingBean   // 위에 HikariDataSourceBean 이 만들어 지지 않았으면 해당 Bean 을 만듦
    DataSource dataSource(MyDataSourceProperties properties) throws ClassNotFoundException {
        // 실제 운영시스템에 사용시 엄청나게 느려짐 실제 운영에는 사용 하면 안됨
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();

        dataSource.setDriverClass((Class<? extends Driver>) Class.forName(properties.getDriverClassName()));
        dataSource.setUrl(properties.getUrl());
        dataSource.setUsername(properties.getUserName());
        dataSource.setPassword(properties.getPassword());

        return dataSource;
    }

    // JDBC Template 은 개발자가 JDBC 기술을 쉽게 사용할 수 있도록 도와주는 클래스
    @Bean
    // 아래 어노테이션은 DataSource Bean 이 딱 한개만 등록이 되어 있다면 해당 정보를 가져와서 사용하겠다는 의미
    @ConditionalOnSingleCandidate(DataSource.class) // 이 Bean 메서드가 실행 될 때 SpringCOntainer 구성 정보가딱 
    @ConditionalOnMissingBean
    JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
    
    // 직접 Access 하여 Transaction 을 사용할 수도 있지만 
    // 어노테이션을 사용하여 Transaction 들을 관리
    @Bean
    // 아래 어노테이션은 DataSource Bean 이 딱 한개만 등록이 되어 있다면 해당 정보를 가져와서 사용하겠다는 의미
    @ConditionalOnSingleCandidate(DataSource.class) // 이 Bean 메서드가 실행 될 때 SpringCOntainer 구성 정보가딱
    @ConditionalOnMissingBean
    JdbcTransactionManager jdbcTransactionManager(DataSource dataSource) {
        return new JdbcTransactionManager(dataSource);
    }

}
