package com.tedu.weibopractice2.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.tedu.weibopractice2.mapper")
public class MybatisMapperScan {
}
