package com.tedu.weibopractice3;

import com.tedu.weibopractice3.mapper.CommentMapper;
import com.tedu.weibopractice3.mapper.UserMapper;
import com.tedu.weibopractice3.pojo.entity.Comment;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WeiboPractice3ApplicationTests {
    @Autowired
    private SqlSession sqlSession;

    @Test
    void contextLoads() {
        System.out.println(sqlSession.getConnection());
    }

}
