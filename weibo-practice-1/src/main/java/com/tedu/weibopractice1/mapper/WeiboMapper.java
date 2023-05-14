package com.tedu.weibopractice1.mapper;

import com.tedu.weibopractice1.pojo.entity.Weibo;
import com.tedu.weibopractice1.pojo.vo.WeiboDetailVO;
import com.tedu.weibopractice1.pojo.vo.WeiboVO;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

public interface WeiboMapper {
    /**
     * 發布一條微博
     */
    @Insert("INSERT INTO weibo VALUES (NULL,#{content},#{created},#{uid})")
    Integer insert(Weibo weibo);

    /**
     * 微博列表
     */
    List<WeiboVO> selectIndex();

    /**
     * 微博詳情
     */
    WeiboDetailVO selectById(int id);
}
