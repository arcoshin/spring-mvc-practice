package com.tedu.weibopractice1;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;

@SpringBootTest
class WeiboPractice1ApplicationTests {
    @Autowired
    private SqlSession sqlSession;

    @Test
    void contextLoads() {
        Connection connection = sqlSession.getConnection();
        System.out.println(connection);
    }

}
