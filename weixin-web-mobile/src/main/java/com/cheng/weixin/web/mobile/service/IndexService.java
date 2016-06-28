package com.cheng.weixin.web.mobile.service;

import com.cheng.weixin.rpc.cart.service.RpcCartService;
import com.cheng.weixin.rpc.item.entity.Product;
import com.cheng.weixin.rpc.item.service.RpcProductService;
import com.cheng.weixin.web.mobile.result.Index;
import com.cheng.weixin.web.mobile.result.IndexProduct;
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


    public Index getIndexInfo(String userId) {
        // 图片

        // 通告

        // 商品
        List<IndexProduct> indexProducts = new ArrayList<>();
        List<Product> products = productService.getIndex();
        for (Product product : products) {
            IndexProduct indexProduct = new IndexProduct();
            indexProduct.setId(product.getId());
            indexProduct.setName(product.getName());
            indexProduct.setPrice(product.getSalePrice());
            indexProducts.add(indexProduct);
        }

        // 金额
        Set<String> pids =  cartService.getProductIds(userId);
        BigDecimal totalPrice = new BigDecimal(0);
        for (String pid : pids) {
            Product product = productService.getById(pid);
            totalPrice = totalPrice.add(product.getSalePrice());
        }

        Index index = new Index();
        index.setProducts(indexProducts);
        index.setTotalPirce(totalPrice);

        return index;
    }


}
