package com.tedu.weibopractice2.mapper;

import com.tedu.weibopractice2.pojo.entity.Weibo;
import com.tedu.weibopractice2.pojo.vo.WeiboDetailVO;
import com.tedu.weibopractice2.pojo.vo.WeiboVO;

import java.util.List;


public interface WeiboMapper {

    Integer insert(Weibo weibo);

    List<WeiboVO> selectIndex();

    WeiboDetailVO selectById(Integer id);
}
