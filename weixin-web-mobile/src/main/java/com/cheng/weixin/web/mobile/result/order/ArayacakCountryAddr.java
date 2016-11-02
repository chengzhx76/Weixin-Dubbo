package com.cheng.weixin.web.mobile.result.order;

import java.util.List;

/**
 * Desc:
 * Author: hp
 * Date: 2016/11/2
 */
public class ArayacakCountryAddr {
    private String countryId;
    private String country;
    private List<ArayacakAddr> addrs;

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<ArayacakAddr> getAddrs() {
        return addrs;
    }

    public void setAddrs(List<ArayacakAddr> addrs) {
        this.addrs = addrs;
    }
}
