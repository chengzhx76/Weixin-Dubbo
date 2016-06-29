package com.cheng.weixin.service.system.dao;

import com.cheng.weixin.common.core.dao.BaseDaoMapper;
import com.cheng.weixin.rpc.system.entity.Ad;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Desc:
 * Author: cheng
 * Date: 2016/6/29
 */
@Repository
public interface AdDaoMapper extends BaseDaoMapper<Ad> {
    /**
     * 获取首页的广告图片
     * @return
     */
    List<Ad> loadIndexAds();

}
