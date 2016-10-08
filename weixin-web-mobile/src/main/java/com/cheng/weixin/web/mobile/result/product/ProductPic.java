package com.cheng.weixin.web.mobile.result.product;

/**
 * Desc: 商品详情图片
 * Author: hp
 * Date: 2016/10/8
 */
public class ProductPic {
    private String pictureUrl;
    private int width;
    private int height;

    public ProductPic() {
    }

    public ProductPic(String pictureUrl, int width, int height) {
        this.pictureUrl = pictureUrl;
        this.width = width;
        this.height = height;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
