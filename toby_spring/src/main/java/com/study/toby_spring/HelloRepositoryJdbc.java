package com.study.toby_spring;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository // Repository 라는 stereotype 어노테이션 사용
public class HelloRepositoryJdbc implements HelloRepository {
    private final JdbcTemplate jdbcTemplate;

    public HelloRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Hello findHello(String name) {
        // 아래 functional interface 이기에 아래 람다식으로 return 하도록 변경
//        return jdbcTemplate.queryForObject("SELECT * FROM hello WHERE name= '" + name + "'", new RowMapper<Hello>() {
//            @Override
//            public Hello mapRow(ResultSet rs, int rowNum) throws SQLException {
//                return null;
//            }
//        });

        // functional 인터페이스 이기에 Interface 에 오직 구현하여할 메서드가 1개
        // 하여 람다식으로 변경 (mapRow 는 결과가 하나일 떄 return 하도록 되어 있음)

        // 행이 1개도 Retrun 되지 않을 떄 에는 null 을 Return
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM hello WHERE name = '" + name + "'", (rs, rowNum) -> new Hello(
                    // Row 를 무주건 Return 하여야 하지만 데이터가 없으면
                    rs.getString("name"), rs.getInt("count")
            ));
        } catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void increaseCount(String name) {
        Hello hello = findHello(name);
        // 만약 name 이 데이터가 없으면 insert 를 해주고 존재하면 해당 hello 를 count 를 1을 올려주도록
        if(hello == null) jdbcTemplate.update("INSERT INTO hello values(?, ?)", name, 1);
        else jdbcTemplate.update("UPDATE hello set count = ? WHERE name = ? ", (hello.getCount() + 1), name);
    }

}
