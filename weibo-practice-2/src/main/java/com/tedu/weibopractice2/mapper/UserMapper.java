package com.tedu.weibopractice2.mapper;

import com.tedu.weibopractice2.pojo.entity.User;
import com.tedu.weibopractice2.pojo.vo.UserVO;

public interface UserMapper {
    UserVO selectByUsername(String username);

    Integer insert(User user);
}
