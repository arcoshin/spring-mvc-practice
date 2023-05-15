package com.tedu.weibopractice2.controller;

import com.tedu.weibopractice2.mapper.UserMapper;
import com.tedu.weibopractice2.pojo.dto.UserLoginDTO;
import com.tedu.weibopractice2.pojo.dto.UserRegDTO;
import com.tedu.weibopractice2.pojo.entity.User;
import com.tedu.weibopractice2.pojo.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
@RequestMapping("/v1/users/")
public class UserController {
    @Autowired(required = false)
    private UserMapper userMapper;

    /**
     * 註冊
     */
    @RequestMapping("reg")
    public int reg(@RequestBody UserRegDTO userRegDTO) {
        /**
         * 重複性驗證
         */
        UserVO userVO = userMapper.selectByUsername(userRegDTO.getUsername());
        if (null == userVO) {
            /**
             * 通過驗證後向數據庫寫入數據
             */

            //傳參容器
            User user = new User();
            //補齊參數
            BeanUtils.copyProperties(userRegDTO, user);
            user.setCreated(new Date());
            //存入數據庫
            userMapper.insert(user);

            return 1;//註冊成功
        }
        return 2;//用戶已存在
    }

    /**
     * 登入
     */
    @RequestMapping("login")
    public int login(@RequestBody UserLoginDTO userLoginDTO, HttpSession session) {
        /**
         * 註冊驗證
         */
        UserVO userVO = userMapper.selectByUsername(userLoginDTO.getUsername());
        if (null != userVO) {
            /**
             * 通過驗證後對比密碼
             */
            if (userVO.getPassword().equals(userLoginDTO.getPassword())) {
                session.setAttribute("user", userVO);
                return 1;
            }
            return 2;//密碼錯誤
        }
        return 3;//用戶不存在
    }

    /**
     * 登入狀態
     */
    @RequestMapping("currentUser")
    public UserVO currentUser(HttpSession session){
        return (UserVO) session.getAttribute("user");
    }

    /**
     * 退出登入
     */
    @RequestMapping("logout")
    private void logout(HttpSession session){
        session.removeAttribute("user");
    }

}
