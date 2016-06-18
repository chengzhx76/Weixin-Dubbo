package com.cheng.weixin.rpc.system.entity;

import com.cheng.common.entity.DataEntity;

/**
 * Desc: 广告与位置关联
 * Author: 光灿
 * Date: 2016/6/18
 */
public class AdJoinPosition extends DataEntity<AdJoinPosition> {
    private String adId;
    private String adPositionId;

    public String getAdId() {
        return adId;
    }

    public AdJoinPosition setAdId(String adId) {
        this.adId = adId;
        return this;
    }

    public String getAdPositionId() {
        return adPositionId;
    }

    public AdJoinPosition setAdPositionId(String adPositionId) {
        this.adPositionId = adPositionId;
        return this;
    }
}
