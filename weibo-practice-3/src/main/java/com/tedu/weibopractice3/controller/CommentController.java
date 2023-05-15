package com.tedu.weibopractice3.controller;

import com.tedu.weibopractice3.mapper.CommentMapper;
import com.tedu.weibopractice3.pojo.dto.CommentDTO;
import com.tedu.weibopractice3.pojo.entity.Comment;
import com.tedu.weibopractice3.pojo.vo.CommentVO;
import com.tedu.weibopractice3.pojo.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/comment/")
public class CommentController {
    @Autowired(required = false)
    private CommentMapper commentMapper;

    @PostMapping("insert")
    public int insert(@RequestBody CommentDTO commentDTO, HttpSession session) {
        /**
         * 驗證登入
         */
        UserVO userVO = (UserVO) session.getAttribute("user");
        if (userVO != null) {
            /**
             * 通過驗證後存入數據庫
             */
            //傳參容器
            Comment comment = new Comment();
            //補齊參數
            BeanUtils.copyProperties(commentDTO,comment);
            comment.setCreated(new Date());
            comment.setUserId(userVO.getId());
            //存入數據庫
            commentMapper.insert(comment);

            return 1;
        }
        return 2;//尚未登入
    }

    @GetMapping("selectByWeiboId")
    public List<CommentVO> selectByWeiboId(int id) {
        return commentMapper.selectByWeiboId(id);
    }

}
