package com.cheng.comment.test;

import com.alibaba.fastjson.JSON;
import com.cheng.weixin.rpc.comment.entity.Comment;
import com.cheng.weixin.rpc.comment.service.RpcCommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Desc:
 * Author: cheng
 * Date: 2016/7/11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/spring-context.xml"})
public class TestMain {
    @Autowired
    private RpcCommentService commentService;

    @Test
    public void test01() {
        List<Comment> comments = commentService.getByProductId("1");
        System.out.println(JSON.toJSONString(comments));
    }

}
