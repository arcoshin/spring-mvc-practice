package com.tedu.weibopractice2.controller;

import com.tedu.weibopractice2.mapper.WeiboMapper;
import com.tedu.weibopractice2.pojo.dto.WeiboDTO;
import com.tedu.weibopractice2.pojo.entity.Weibo;
import com.tedu.weibopractice2.pojo.vo.UserVO;
import com.tedu.weibopractice2.pojo.vo.WeiboDetailVO;
import com.tedu.weibopractice2.pojo.vo.WeiboVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/weibo")
public class WeiboController {
    @Autowired(required = false)
    private WeiboMapper weiboMapper;

    /**
     * 新增一條微博
     */
    @RequestMapping("insert")
    public int insert(@RequestBody WeiboDTO weiboDTO, HttpSession session) {
        /**
         * 登入驗證
         */
        UserVO userVO = (UserVO) session.getAttribute("user");
        if (null != userVO) {
            /**
             * 通過驗證後存入數據庫
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
        return 2;//請先登入
    }

    /**
     * 微博列表
     */
    @RequestMapping("selectIndex")
    public List<WeiboVO> selectIndex(){
        return weiboMapper.selectIndex();
    }

    /**
     * 透過id查詢微博
     */
    @RequestMapping("selectById")
    public WeiboDetailVO selectById(int id) {
        return weiboMapper.selectById(id);
    }










}
