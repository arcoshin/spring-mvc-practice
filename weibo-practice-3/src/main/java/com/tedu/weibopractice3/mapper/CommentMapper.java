package com.tedu.weibopractice3.mapper;

import com.tedu.weibopractice3.pojo.entity.Comment;
import com.tedu.weibopractice3.pojo.vo.CommentVO;

import java.util.List;

public interface CommentMapper {
    Integer insert(Comment comment);

    List<CommentVO> selectByWeiboId(int id);
}
