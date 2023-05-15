package com.tedu.weibopractice3.pojo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Weibo {
    private Integer id;
    private String content;
    private Date created;
    private Integer userId;
}
