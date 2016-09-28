package com.cheng.weixin.rpc.user.entity;

import com.cheng.common.entity.DataEntity;

/**
 * Desc: 配送地址
 * Author: cheng
 * Date: 2016/6/3
 */
public class DeliveryAddress extends DataEntity<DeliveryAddress> {
    private String accountId;
    private int regionProvinceId;
    private int regionCityId;
    private int regionCountryId;
    private int villageId;
    private String consignee;
    private String address;
    private String mobile;
    private String telephone;
    private String email;
    private String postCode;
    private boolean isDefault;

    public DeliveryAddress() {
    }

    public DeliveryAddress(String accountId, boolean isDefault) {
        this.accountId = accountId;
        this.isDefault = isDefault;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public int getRegionProvinceId() {
        return regionProvinceId;
    }

    public void setRegionProvinceId(int regionProvinceId) {
        this.regionProvinceId = regionProvinceId;
    }

    public int getRegionCityId() {
        return regionCityId;
    }

    public void setRegionCityId(int regionCityId) {
        this.regionCityId = regionCityId;
    }

    public int getRegionCountryId() {
        return regionCountryId;
    }

    public void setRegionCountryId(int regionCountryId) {
        this.regionCountryId = regionCountryId;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public int getVillageId() {
        return villageId;
    }

    public void setVillageId(int villageId) {
        this.villageId = villageId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }
}
