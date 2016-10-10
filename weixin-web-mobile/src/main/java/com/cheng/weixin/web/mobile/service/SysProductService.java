package com.cheng.weixin.web.mobile.service;

import com.cheng.weixin.common.utils.StringFormat;
import com.cheng.weixin.rpc.cart.service.RpcCartService;
import com.cheng.weixin.rpc.comment.entity.Comment;
import com.cheng.weixin.rpc.comment.service.RpcCommentService;
import com.cheng.weixin.rpc.item.entity.Picture;
import com.cheng.weixin.rpc.item.entity.Product;
import com.cheng.weixin.rpc.item.service.RpcProductService;
import com.cheng.weixin.rpc.user.entity.Account;
import com.cheng.weixin.rpc.user.service.RpcUserService;
import com.cheng.weixin.web.mobile.result.comment.ProductComment;
import com.cheng.weixin.web.mobile.result.product.ProductDetail;
import com.cheng.weixin.web.mobile.result.product.ProductPic;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc:
 * Author: hp
 * Date: 2016/10/8
 */
@Service
public class SysProductService {
    @Autowired
    private RpcProductService productService;
    @Autowired
    private RpcCommentService commentService;
    @Autowired
    private RpcUserService userService;
    @Autowired
    private RpcCartService cartService;
    /**
     * 详情页
     * @param productId
     * @return
     */
    public ProductDetail getDetail(String productId) {
        Product product = productService.getById(productId);
        List<Picture> pictures = productService.getAllPicture(productId);

        ProductDetail detail = new ProductDetail();
        detail.setProductId(product.getId());
        detail.setName(product.getName());
        detail.setDesc(product.getUnitDesc());
        detail.setSellNum(99);
        detail.setGood(98);
        detail.setMarketPrice(StringFormat.format(product.getMarketPrice()));
        detail.setMarketPrice(StringFormat.format(product.getMarketPrice()));

        List<ProductPic> pics = new ArrayList<>();
        for (Picture picture : pictures) {
            pics.add(new ProductPic(picture.getPictureUrl(), picture.getWidth(), picture.getHeight()));
        }
        detail.setPicList(pics);

        List<Comment> commentes = commentService.getByProductId(productId);

        List<ProductComment> productComment = new ArrayList<>();
        for (Comment comment : commentes) {
            Account account = userService.getAccountById(comment.getAccountId());
            // TODO 等级
            productComment.add(new ProductComment(account.getUsername(), "1",
                    new DateTime(comment.getCreateDate()).toString("dd-MM-yyyy HH:mm:ss"), comment.getContent(),"回复"));
        }
        detail.setComments(productComment);
        return detail;
    }

    public void buyProduct(String productId, Long count) {
        cartService.addProduct("1", productId, count);
    }

    public boolean addFocus(String productId) {
        boolean isFocus = userService.isProductFocus("1", productId);
        if (!isFocus) {
            userService.addProductFocus("1", productId);
        }
        return isFocus;
    }

}
