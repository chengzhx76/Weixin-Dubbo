package com.cheng.weixin.service.system.service;

import com.cheng.weixin.rpc.system.entity.Ad;
import com.cheng.weixin.rpc.system.entity.Notice;
import com.cheng.weixin.rpc.system.service.RpcSystemService;
import com.cheng.weixin.service.system.dao.AdDaoMapper;
import com.cheng.weixin.service.system.dao.NoticeDaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Desc: 广告
 * Author: cheng
 * Date: 2016/6/29
 */
@Service("systemService")
public class SystemService implements RpcSystemService {
    @Autowired
    private AdDaoMapper adDao;
    @Autowired
    private NoticeDaoMapper noticeDao;
    /**
     * 获取首页的图片
     *
     * @return
     */
    @Override
    public List<Ad> getIndexAds() {
        return adDao.loadIndexAds();
    }

    /**
     * 获取首页的公告
     *
     * @return
     */
    @Override
    public List<Notice> getIndexNotices() {
        return noticeDao.loadAll();
    }
}
