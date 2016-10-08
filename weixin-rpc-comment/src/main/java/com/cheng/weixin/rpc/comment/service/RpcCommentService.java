package com.cheng.weixin.rpc.comment.service;

import com.cheng.weixin.rpc.comment.entity.Comment;

import java.util.List;

/**
 * Desc: 评论
 * Author: hp
 * Date: 2016/10/8
 */
public interface RpcCommentService {
    /**
     * 获取该商品的评论
     * @param productId
     * @return
     */
    List<Comment> getByProductId(String productId);
}
