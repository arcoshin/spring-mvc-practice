package com.tedu.weibopractice1.mapper;

import com.tedu.weibopractice1.pojo.entity.User;
import com.tedu.weibopractice1.pojo.vo.UserVO;
import org.apache.ibatis.annotations.Insert;

public interface UserMapper {
    /**
     * 藉由id查詢用戶數據
     */
    UserVO selectByUsername(String username);

    /**
     * 新增一條用戶數據
     */
    @Insert("Insert INTO user VALUES(NULL,#{username},#{password},#{nickname},#{created})")
    Integer insert(User user);
}
