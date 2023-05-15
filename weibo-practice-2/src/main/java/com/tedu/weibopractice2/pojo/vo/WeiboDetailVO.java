package com.tedu.weibopractice2.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class WeiboDetailVO {
    private Integer id;
    private String nickname;
    private String content;
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:SS",timezone = "GMT+8")
    private Date created;

    @Override
    public String toString() {
        return "WeiboDetailVO{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", content='" + content + '\'' +
                ", created=" + created +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
