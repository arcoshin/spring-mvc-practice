package com.tedu.weibopractice3.pojo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommentDTO {
    private String content;
    private Integer weiboId;
}
