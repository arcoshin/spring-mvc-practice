package com.tedu.weibopractice1.controller;

import com.tedu.weibopractice1.mapper.WeiboMapper;
import com.tedu.weibopractice1.pojo.dto.WeiboDTO;
import com.tedu.weibopractice1.pojo.entity.Weibo;
import com.tedu.weibopractice1.pojo.vo.UserVO;
import com.tedu.weibopractice1.pojo.vo.WeiboDetailVO;
import com.tedu.weibopractice1.pojo.vo.WeiboVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/weibo/")
public class WeiboController {
    @Autowired(required = false)
    private WeiboMapper weiboMapper;

    /**
     * 新增一條微博
     */
    @RequestMapping("insert")
    public int insert(@RequestBody WeiboDTO weiboDTO, HttpSession session) {
        System.out.println("weiboDTO = " + weiboDTO);
        /**
         * 登入狀態驗證
         */
        UserVO userVo = (UserVO) session.getAttribute("user");
        System.out.println("userVo = " + userVo);
        if (null != userVo) {
            /**
             * 發表微博
             */
            //建立傳參容器
            Weibo weibo = new Weibo();
            //補齊參數
            BeanUtils.copyProperties(weiboDTO, weibo);
            weibo.setCreated(new Date());
            weibo.setUid(userVo.getId());
            //存入數據庫
            weiboMapper.insert(weibo);

            return 1;//成功發表
        }
        return 2;//尚未登入
    }

    /**
     * 微博列表
     */
    @RequestMapping("selectIndex")
    public List<WeiboVO> selectIndex() {
        return weiboMapper.selectIndex();
    }

    /**
     * 微博詳情
     */
    @RequestMapping("selectById")
    public WeiboDetailVO selectById(int id){
        return weiboMapper.selectById(id);
    }




}
