package com.cheng.weixin.web.mobile.result.order;

/**
 * Desc:
 * Author: hp
 * Date: 2016/11/2
 */
public class ArayacakTownAddr {
    private String townId;
    private String town;

    public ArayacakTownAddr() {
    }

    public ArayacakTownAddr(String townId, String town) {
        this.townId = townId;
        this.town = town;
    }

    public String getTownId() {
        return townId;
    }

    public void setTownId(String townId) {
        this.townId = townId;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
