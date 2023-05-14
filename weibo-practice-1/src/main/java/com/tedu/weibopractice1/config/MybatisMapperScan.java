package com.tedu.weibopractice1.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.tedu.weibopractice1.mapper")
public class MybatisMapperScan {
}
