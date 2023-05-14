package com.tedu.weibopractice1.mapper;

import com.tedu.weibopractice1.pojo.entity.Comment;
import com.tedu.weibopractice1.pojo.vo.CommentVO;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

public interface CommentMapper {
    /**
     * 新增一條評論
     */
    @Insert("INSERT INTO comment VALUES (NULL,#{content},#{created},#{uid},#{wid})")
    int insert(Comment comment);

    /**
     * 評論列表
     */
    List<CommentVO> selectByWeiboId(int id);
}
