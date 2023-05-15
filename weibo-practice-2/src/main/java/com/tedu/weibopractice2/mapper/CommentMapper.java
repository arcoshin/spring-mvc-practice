package com.tedu.weibopractice2.mapper;

import com.tedu.weibopractice2.pojo.entity.Comment;

import java.util.List;

public interface CommentMapper {
    Integer insert(Comment comment);

    List<Comment> selectByWeiboId(Integer weiboId);
}
