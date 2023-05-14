package com.tedu.weibopractice1.controller;

import com.tedu.weibopractice1.mapper.CommentMapper;
import com.tedu.weibopractice1.pojo.dto.CommentDTO;
import com.tedu.weibopractice1.pojo.entity.Comment;
import com.tedu.weibopractice1.pojo.vo.CommentVO;
import com.tedu.weibopractice1.pojo.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/comment/")
public class CommentController {
    @Autowired(required = false)
    private CommentMapper commentMapper;

    /**
     * 新增一條評論
     */
    @RequestMapping("insert")
    public int insert(@RequestBody CommentDTO commentDTO, HttpSession session) {
        System.out.println("commentDTO = " + commentDTO);
        /**
         * 驗證登入狀態
         */
        UserVO userVO = (UserVO) session.getAttribute("user");
        if (null != userVO) {
            /**
             * 通過驗證後發布評論
             */
            //準備傳參容器
            Comment comment = new Comment();
            //補齊參數
            BeanUtils.copyProperties(commentDTO,comment);
            comment.setCreated(new Date());
            comment.setUid(userVO.getId());
            comment.setWid(commentDTO.getWeiboId());
            //傳入數據庫
            commentMapper.insert(comment);
            return 1;
        }
        return 2;
    }

    /**
     * 評論列表
     */
    @RequestMapping("selectByWeiboId")
    public List<CommentVO> selectByWeiboId(int id) {
        return commentMapper.selectByWeiboId(id);
    }



}
