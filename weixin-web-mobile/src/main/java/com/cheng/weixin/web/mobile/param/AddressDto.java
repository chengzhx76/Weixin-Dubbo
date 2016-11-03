package com.cheng.weixin.web.mobile.param;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Desc:
 * Author: hp
 * Date: 2016/11/3
 */
public class AddressDto {
    private String id;
    private Boolean isSince;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getSince() {
        return isSince;
    }

    public void setSince(Boolean since) {
        isSince = since;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("isSince", isSince)
                .toString();
    }
}
