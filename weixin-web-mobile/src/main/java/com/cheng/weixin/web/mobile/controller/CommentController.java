package com.cheng.weixin.web.mobile.controller;

import com.cheng.weixin.common.model.Page;
import com.cheng.weixin.web.mobile.model.Response;
import com.cheng.weixin.web.mobile.param.PageDto;
import com.cheng.weixin.web.mobile.result.comment.ProductComment;
import com.cheng.weixin.web.mobile.security.IgnoreSecurity;
import com.cheng.weixin.web.mobile.service.SysCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Desc: 首页
 * Author: cheng
 * Date: 2016/6/21
 */
@RestController
@RequestMapping("comment")
public class CommentController extends BaseController {
    @Autowired
    private SysCommentService commentService;

    @IgnoreSecurity
    @RequestMapping(value = "v1/item/all")
    public ResponseEntity<Response> itemComment(HttpServletRequest request) {
        PageDto productDto = (PageDto) getDto(request, PageDto.class);
        Page<ProductComment> comment = commentService.getCommentByProductId(productDto.getPageNum(), productDto.getPageSize(), productDto.getId());
        return success(comment);
    }


}
