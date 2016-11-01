package com.cheng.weixin.service.comment.service;

import com.cheng.weixin.rpc.comment.entity.Comment;
import com.cheng.weixin.rpc.comment.service.RpcCommentService;
import com.cheng.weixin.service.comment.dao.CommentDaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Desc: 评论
 * Author: hp
 * Date: 2016/10/8
 */
@Service("commentService")
public class CommentService implements RpcCommentService {
    @Autowired
    private CommentDaoMapper commentDao;

    @Override
    public List<Comment> getByProductId(String productId) {
        return commentDao.loadAll(new Comment(productId));
    }
}
