package com.tedu.weibopractice3.mapper;

import com.tedu.weibopractice3.pojo.entity.User;
import com.tedu.weibopractice3.pojo.vo.UserVO;

public interface UserMapper {

    UserVO selectByUsername(String username);

    Integer insert(User user);
}
