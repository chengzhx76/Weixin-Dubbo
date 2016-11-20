package com.cheng.weixin.web.mobile.service;

import com.cheng.weixin.common.utils.StringFormat;
import com.cheng.weixin.common.utils.StringUtils;
import com.cheng.weixin.rpc.cart.service.RpcCartService;
import com.cheng.weixin.rpc.comment.entity.Comment;
import com.cheng.weixin.rpc.comment.service.RpcCommentService;
import com.cheng.weixin.rpc.item.entity.Picture;
import com.cheng.weixin.rpc.item.entity.Product;
import com.cheng.weixin.rpc.item.service.RpcProductService;
import com.cheng.weixin.rpc.user.entity.Account;
import com.cheng.weixin.rpc.user.service.RpcUserService;
import com.cheng.weixin.web.mobile.exception.ProductException;
import com.cheng.weixin.web.mobile.exception.message.StatusCode;
import com.cheng.weixin.web.mobile.result.comment.ProductComment;
import com.cheng.weixin.web.mobile.result.product.ProductDetail;
import com.cheng.weixin.web.mobile.result.product.ProductPic;
import com.cheng.weixin.web.mobile.security.LocalUser;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Desc:
 * Author: hp
 * Date: 2016/10/8
 */
@Service
public class SysProductService {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

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
        List<Picture> pictures = productService.getShowPictureByProductId(productId);
        boolean isFocus = userService.isProductFocus(LocalUser.getUser().getUserId(), productId);

        ProductDetail detail = new ProductDetail();
        detail.setProductId(product.getId());
        detail.setName(product.getName());
        detail.setDesc(product.getUnitDesc());
        detail.setSellNum(99);
        detail.setGood(98);
        detail.setSellPrice(StringFormat.format(product.getSalePrice()));
        detail.setMarketPrice(StringFormat.format(product.getMarketPrice()));
        detail.setGiveAway(product.getGiveAway());
        detail.setFocus(isFocus);
        if (cartService.exists(LocalUser.getUser().getUserId(), productId)) {
            Long count = cartService.getCounts(LocalUser.getUser().getUserId(), productId);
            detail.setCount(count+"");
            BigDecimal totalPrice = BigDecimal.valueOf(count).multiply(product.getSalePrice());
            detail.setTotalPrice(StringFormat.format(totalPrice));
        }else {
            detail.setCount("1");
            detail.setTotalPrice(StringFormat.format(product.getSalePrice()));
        }
        List<ProductPic> pics = new ArrayList<>();
        for (Picture picture : pictures) {
            pics.add(new ProductPic(picture.getPictureUrl(), picture.getWidth(), picture.getHeight()));
        }
        detail.setPicList(pics);

        List<Comment> commentes = commentService.getByProductId(productId);
        List<ProductComment> productComments = new ArrayList<>();
        for (Comment comment : commentes) {
            Account account = userService.getAccountById(comment.getAccountId());
            ProductComment productComment = new ProductComment();
            productComment.setUsername(StringUtils.hidePhone(account.getUsername()));
            productComment.setAvatar(account.getAvatar());
            productComment.setLevel("1");// TODO 等级
            productComment.setDate(new DateTime(comment.getCreateDate()).toString("yyyy-dd-MM HH:mm:ss"));
            productComment.setContent(comment.getContent());
            productComment.setReply("回复");
            productComments.add(productComment);
        }
        detail.setComments(productComments);
        return detail;
    }

    public void buyProduct(String productId, Long count) {
        Product product = productService.getById(productId);
        if (product.getUnitsInStock() < count) {
            throw new ProductException(StatusCode.PRODUCT_STOCK_SHORTAGE);
        }
        cartService.addProduct(LocalUser.getUser().getUserId(), productId, count);
    }

    public boolean focus(String productId) {
        boolean isFocus = userService.isProductFocus(LocalUser.getUser().getUserId(), productId);
        if (isFocus) {
            userService.deleteProductFocus(LocalUser.getUser().getUserId(), productId);
        }else {
            userService.addProductFocus(LocalUser.getUser().getUserId(), productId);
        }
        return !isFocus;
    }

}
