package com.cheng.weixin.rpc.system.service;

import com.cheng.weixin.rpc.system.entity.Ad;
import com.cheng.weixin.rpc.system.entity.Notice;

import java.util.List;

/**
 * Desc: 广告
 * Author: cheng
 * Date: 2016/6/29
 */
public interface RpcSystemService {
    /**
     * 获取首页的图片
     * @return
     */
    List<Ad> getIndexAds();

    /**
     * 获取首页的公告
     * @return
     */
    List<Notice> getIndexNotices();

}
