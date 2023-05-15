package com.tedu.weibopractice3.controller;

import com.tedu.weibopractice3.mapper.WeiboMapper;
import com.tedu.weibopractice3.pojo.dto.WeiboDTO;
import com.tedu.weibopractice3.pojo.entity.Weibo;
import com.tedu.weibopractice3.pojo.vo.UserVO;
import com.tedu.weibopractice3.pojo.vo.WeiboDetailVO;
import com.tedu.weibopractice3.pojo.vo.WeiboIndexVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/weibo/")
public class WeiboController {
    @Autowired(required = false)
    private WeiboMapper weiboMapper;

    @PostMapping("insert")
    public int insert(@RequestBody WeiboDTO weiboDTO, HttpSession session) {
        /**
         * 驗證登入
         */
        UserVO userVO = (UserVO) session.getAttribute("user");
        if (userVO != null) {
            /**
             * 通過驗證則存入數據庫
             */
            //傳參容器
            Weibo weibo = new Weibo();
            //補齊參數
            BeanUtils.copyProperties(weiboDTO,weibo);
            weibo.setCreated(new Date());
            weibo.setUserId(userVO.getId());
            //存入數據庫
            weiboMapper.insert(weibo);

            return 1;//發布成功
        }
        return 2;//尚未登入
    }

    @GetMapping("selectIndex")
    public List<WeiboIndexVO> selectIndex() {
        return weiboMapper.selectIndex();
    }

    @GetMapping("selectById")
    public WeiboDetailVO selectById(int id){
        return weiboMapper.selectById(id);
    }
}
