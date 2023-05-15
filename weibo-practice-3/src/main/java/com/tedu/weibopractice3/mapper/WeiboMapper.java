package com.tedu.weibopractice3.mapper;

import com.tedu.weibopractice3.pojo.entity.Weibo;
import com.tedu.weibopractice3.pojo.vo.WeiboDetailVO;
import com.tedu.weibopractice3.pojo.vo.WeiboIndexVO;

import java.util.List;

public interface WeiboMapper {
    Integer insert(Weibo weibo);

    List<WeiboIndexVO> selectIndex();

    WeiboDetailVO selectById(int id);
}
