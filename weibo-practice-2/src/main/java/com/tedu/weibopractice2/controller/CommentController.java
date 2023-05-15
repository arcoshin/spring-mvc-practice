package com.tedu.weibopractice2.controller;

import com.tedu.weibopractice2.mapper.CommentMapper;
import com.tedu.weibopractice2.pojo.dto.CommentDTO;
import com.tedu.weibopractice2.pojo.entity.Comment;
import com.tedu.weibopractice2.pojo.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/comment")
public class CommentController {
    @Autowired(required = false)
    private CommentMapper commentMapper;

    @RequestMapping("insert")
    public int insert(@RequestBody CommentDTO commentDTO, HttpSession session) {
        /**
         * 登入狀態驗證
         */
        UserVO userVO = (UserVO) session.getAttribute("user");
        if (null != userVO) {
            /**
             * 通過驗證後新增一條評論數據
             */
            //傳參容器
            Comment comment = new Comment();
            //補齊參數
            BeanUtils.copyProperties(commentDTO,comment);
            comment.setCreated(new Date());
            comment.setUserId(userVO.getId());
            //傳入數據庫
            commentMapper.insert(comment);

            return 1;//發布成功
        }
        return 2;//請先登入
    }

    @RequestMapping("selectByWeiboId")
    public List<Comment> selectByWeiboId(int id){
        return commentMapper.selectByWeiboId(id);
    }


}
