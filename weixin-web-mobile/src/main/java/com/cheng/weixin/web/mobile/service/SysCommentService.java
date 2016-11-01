package com.cheng.weixin.web.mobile.service;

import com.cheng.weixin.common.model.Page;
import com.cheng.weixin.rpc.comment.entity.Comment;
import com.cheng.weixin.rpc.comment.service.RpcCommentService;
import com.cheng.weixin.web.mobile.result.comment.ProductComment;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc: 评论
 * Author: hp
 * Date: 2016/11/1
 */
@Service("sysCommentService")
public class SysCommentService {
    @Autowired
    private RpcCommentService commentService;

    public Page<ProductComment> getCommentByProductId(int pageNum, int pageSize, String productId) {
        PageHelper.startPage(pageNum, pageSize);
        List<Comment> comments = commentService.getByProductId(productId);
        List<ProductComment> productComments = new ArrayList<>();
        for (Comment comment : comments) {
            ProductComment productComment = new ProductComment();
            productComment.setDate("");
            productComment.setAvatar("");
            productComment.setUsername("");
            productComment.setContent(comment.getContent());
            productComment.setReply("");
            productComment.setLevel("");
            productComments.add(productComment);
        }

        PageInfo<ProductComment> pageInfo = new PageInfo<>(productComments);
        Page<ProductComment> commentPage = new Page<>();
        BeanUtils.copyProperties(commentPage, pageInfo);
        commentPage.setList(productComments);
        return commentPage;
    }
}
