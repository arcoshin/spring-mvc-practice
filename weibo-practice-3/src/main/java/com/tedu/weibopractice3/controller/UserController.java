package com.tedu.weibopractice3.controller;

import com.tedu.weibopractice3.mapper.UserMapper;
import com.tedu.weibopractice3.pojo.dto.UserLoginDTO;
import com.tedu.weibopractice3.pojo.dto.UserRegDTO;
import com.tedu.weibopractice3.pojo.entity.User;
import com.tedu.weibopractice3.pojo.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
@RequestMapping("/v1/users/")
public class UserController {
    @Autowired(required = false)
    private UserMapper userMapper;

    @PostMapping("reg")
    public int reg(@RequestBody UserRegDTO userRegDTO) {
        System.out.println("userRegDTO = " + userRegDTO);
        /**
         * 重複性驗證
         */
        UserVO userVO = userMapper.selectByUsername(userRegDTO.getUsername());
        System.out.println("userVO = " + userVO);
        if (userVO == null) {
            /**
             * 通過驗證後寫入數據庫
             */
            //傳參容器
            User user = new User();
            //傳遞參數
            BeanUtils.copyProperties(userRegDTO,user);
            //補齊參數
            user.setCreated(new Date());
            //存入數據庫
            userMapper.insert(user);

            return 1;//註冊成功
        }
        return 2;//重複註冊
    }

    @PostMapping("login")
    public int login(@RequestBody UserLoginDTO userLoginDTO, HttpSession session) {
        /**
         * 註冊驗證
         */
        UserVO userVO = userMapper.selectByUsername(userLoginDTO.getUsername());
        if (userVO != null) {
            /**
             * 通過驗證則比對密碼
             */
            if (userVO.getPassword().equals(userLoginDTO.getPassword())){
                session.setAttribute("user",userVO);
                return 1;//登入成功
            }
            return 2;//密碼錯誤
        }
        return 3;//用戶不存在
    }

    @GetMapping("currentUser")
    public UserVO currentUser(HttpSession session){
        return (UserVO) session.getAttribute("user");
    }

    @GetMapping("logout")
    public void logout(HttpSession session) {
        session.removeAttribute("user");
    }

}
