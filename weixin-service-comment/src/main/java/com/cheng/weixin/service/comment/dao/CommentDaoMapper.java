package com.cheng.weixin.service.comment.dao;

import com.cheng.weixin.common.core.dao.BaseDaoMapper;
import com.cheng.weixin.rpc.comment.entity.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Desc: 评论
 * Author: hp
 * Date: 2016/10/8
 */
@Repository
public interface CommentDaoMapper extends BaseDaoMapper<Comment> {
    /**
     * 获取商品的评论
     * @param comment
     * @return
     */
    List<Comment> getByProductId(Comment comment);
}
