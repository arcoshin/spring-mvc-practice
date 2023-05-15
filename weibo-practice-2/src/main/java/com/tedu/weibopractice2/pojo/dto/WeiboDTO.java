package com.tedu.weibopractice2.pojo.dto;

public class WeiboDTO {
    private String content;

    @Override
    public String toString() {
        return "WeiboDTO{" +
                "content='" + content + '\'' +
                '}';
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
