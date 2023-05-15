package com.tedu.weibopractice3.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class CommentVO {
    private Integer id;
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:SS",timezone = "GMT+8")
    private Date created;
    private String content;
    private String nickname;
}
