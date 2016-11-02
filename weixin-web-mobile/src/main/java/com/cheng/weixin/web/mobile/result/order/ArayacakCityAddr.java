package com.cheng.weixin.web.mobile.result.order;

import java.util.List;

/**
 * Desc:
 * Author: hp
 * Date: 2016/11/2
 */
public class ArayacakCityAddr {
    private String cid;
    private String city;
    private List<ArayacakCountryAddr> countryAddrs;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<ArayacakCountryAddr> getCountryAddrs() {
        return countryAddrs;
    }

    public void setCountryAddrs(List<ArayacakCountryAddr> countryAddrs) {
        this.countryAddrs = countryAddrs;
    }
}
