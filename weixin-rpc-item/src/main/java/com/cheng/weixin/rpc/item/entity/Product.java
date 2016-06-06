package com.cheng.weixin.rpc.item.entity;

import com.cheng.common.entity.DataEntity;

/**
 * Desc: 商品
 * Author: cheng
 * Date: 2016/6/6
 */
public class Product extends DataEntity<Product> {
    private String name;
    private String no;
    private String keywords;
    private int productTypeId;
    private boolean isAlive;
    private int warehouseId;
    private int supplierId;
    private int modifyAdminId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public int getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(int productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getModifyAdminId() {
        return modifyAdminId;
    }

    public void setModifyAdminId(int modifyAdminId) {
        this.modifyAdminId = modifyAdminId;
    }
}
