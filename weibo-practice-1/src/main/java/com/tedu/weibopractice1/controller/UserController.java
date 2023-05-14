package com.tedu.weibopractice1.controller;

import com.tedu.weibopractice1.mapper.UserMapper;
import com.tedu.weibopractice1.pojo.dto.UserLoginDTO;
import com.tedu.weibopractice1.pojo.dto.UserRegDTO;
import com.tedu.weibopractice1.pojo.entity.User;
import com.tedu.weibopractice1.pojo.vo.UserVO;
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
        System.out.println("userRegDTO = " + userRegDTO);
        /**
         * 透過檢索用戶名進行重複性驗證
         */
        UserVO userVo = userMapper.selectByUsername(userRegDTO.getUsername());
        System.out.println("userVO = " + userVo);
        if (null != userVo) {
            return 2;
        }

        /**
         * 通過驗證則向數據庫存入數據
         */
        //建立傳參容器
        User user = new User();
        //補齊參數
        BeanUtils.copyProperties(userRegDTO, user);
        user.setCreated(new Date());
        //新增一條用戶數據
        userMapper.insert(user);
        return 1;
    }

    /**
     * 登入
     */
    @RequestMapping("login")
    public int login(@RequestBody UserLoginDTO userLoginDTO, HttpSession session) {
        System.out.println("userLoginDTO = " + userLoginDTO);
        /**
         * 藉由用戶名驗證是否完成註冊
         */
        UserVO userVo = userMapper.selectByUsername(userLoginDTO.getUsername());
        if (null != userVo) {

            /**
             * 通過驗證後比對密碼
             */
            if (userLoginDTO.getPassword().equals(userVo.getPassword())) {
                session.setAttribute("user", userVo);
                return 1;//密碼正確登入成功
            }
            return 2;//密碼錯誤
        }
        return 3;//用戶不存在
    }

    /**
     * 判斷登入狀態
     */
    @RequestMapping("currentUser")
    private UserVO currentUser(HttpSession session) {
        UserVO userVo = (UserVO) session.getAttribute("user");
        return userVo;
    }

    /**
     * 登出
     */
    @RequestMapping("logout")
    public void logout(HttpSession session) {
        session.removeAttribute("user");
    }


}
