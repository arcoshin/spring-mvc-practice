package com.tedu.weibopractice3.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.tedu.weibopractice3.mapper")
public class MybatisScan {
}
