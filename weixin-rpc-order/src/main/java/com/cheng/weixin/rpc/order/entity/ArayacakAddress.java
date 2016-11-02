package com.cheng.weixin.rpc.order.entity;

import com.cheng.common.entity.DataEntity;

/**
 * Desc:自提地点
 * Author: 光灿
 * Date: 2016/6/18
 */
public class ArayacakAddress extends DataEntity<ArayacakAddress> {
    private String name;
    private String province;
    private String city;
    private String country;
    private String address;

    public ArayacakAddress(String city, String country) {
        this.city = city;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public ArayacakAddress setName(String name) {
        this.name = name;
        return this;
    }

    public String getProvince() {
        return province;
    }

    public ArayacakAddress setProvince(String province) {
        this.province = province;
        return this;
    }

    public String getCity() {
        return city;
    }

    public ArayacakAddress setCity(String city) {
        this.city = city;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public ArayacakAddress setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public ArayacakAddress setAddress(String address) {
        this.address = address;
        return this;
    }
}
