package com.cheng.weixin.web.mobile.service;

import com.cheng.weixin.rpc.cart.service.RpcCartService;
import com.cheng.weixin.rpc.item.entity.Product;
import com.cheng.weixin.rpc.item.service.RpcProductService;
import com.cheng.weixin.rpc.system.entity.Ad;
import com.cheng.weixin.rpc.system.entity.Notice;
import com.cheng.weixin.rpc.system.service.RpcSystemService;
import com.cheng.weixin.web.mobile.result.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Desc:
 * Author: cheng
 * Date: 2016/6/28
 */
@Service("indexService")
public class IndexService {
    @Autowired
    private RpcCartService cartService;
    @Autowired
    private RpcProductService productService;
    @Autowired
    private RpcSystemService systemService;

    public Index getIndexInfo(String userId) {
        // 图片
        List<IndexAd> indexads = new ArrayList<>();
        List<Ad> ads = systemService.getIndexAds();
        for (Ad ad : ads) {
            IndexAd indexAd = new IndexAd();
            indexAd.setName(ad.getName());
            indexAd.setPictureUrl(ad.getPictureUrl());
            indexAd.setLinkUrl(ad.getLinkUrl());
            indexAd.setHeight(ad.getHeight());
            indexAd.setWidth(ad.getWidth());
            indexads.add(indexAd);
        }
        // 通告
        List<IndexNotice> indexNotices = new ArrayList<>();
        List<Notice> notices = systemService.getIndexNotices();
        for (Notice notice : notices) {
            IndexNotice indexNotice = new IndexNotice();
            indexNotice.setId(notice.getId());
            indexNotice.setContent(notice.getContent());
            indexNotice.setLinkUrl(notice.getLinkUrl());
            indexNotices.add(indexNotice);
        }
        // 商品
        List<IndexProduct> indexProducts = new ArrayList<>();
        List<Product> products = productService.getIndex();
        for (Product product : products) {
            IndexProduct indexProduct = new IndexProduct();
            indexProduct.setId(product.getId());
            indexProduct.setName(product.getName());
            indexProduct.setPrice(product.getSalePrice());
            indexProduct.setPicLink(product.getDefaultPicture().getPictureUrl());
            indexProduct.setHeight(product.getDefaultPicture().getHeight());
            indexProduct.setWidth(product.getDefaultPicture().getWidth());
            indexProduct.setTag(product.getTag());
            indexProduct.setDesc(product.getUnitDesc());
            indexProducts.add(indexProduct);
        }

        // 金额
        BigDecimal totalPrice = totalPrice(userId);

        Index index = new Index();
        index.setAds(indexads);
        index.setNotices(indexNotices);
        index.setProducts(indexProducts);
        index.setTotalPirce(totalPrice);

        return index;
    }

    /**
     * 购买商品
     * @param userId
     * @param productId
     * @return
     */
    public IndexBuy addProduct(String userId, String productId) {
        long count = cartService.addProductCount(userId, productId);
        // 金额
        BigDecimal totalPrice = totalPrice(userId);

        IndexBuy indexBuy = new IndexBuy();
        indexBuy.setCount(count);
        indexBuy.setPrice(totalPrice);
        return indexBuy;
    }
    /**
     * 减少商品
     * @param userId
     * @param productId
     * @return
     */
    public IndexBuy subProduct(String userId, String productId) {
        long count = cartService.subProductCount(userId, productId);
        // 金额
        BigDecimal totalPrice = totalPrice(userId);

        IndexBuy indexBuy = new IndexBuy();
        indexBuy.setCount(count);
        indexBuy.setPrice(totalPrice);
        return indexBuy;
    }

    /**
     * 购物车商品的总价格
     * @param userId
     * @return
     */
    private BigDecimal totalPrice(String userId) {
        Set<String> productIds =  cartService.getProductIds(userId);
        BigDecimal totalPrice = new BigDecimal(0);
        for (String productId : productIds) {

            // 根据Feild获取values 在乘以 单价 = total
            Long counts = cartService.getCounts(userId, productId);

            Product product = productService.getById(productId);
            totalPrice = totalPrice.add(product.getSalePrice().multiply(new BigDecimal(counts)));
        }
        return totalPrice;
    }

}
