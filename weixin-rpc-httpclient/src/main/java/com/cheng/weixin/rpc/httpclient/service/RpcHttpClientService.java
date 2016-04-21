package com.cheng.weixin.rpc.httpclient.service;

/**
 * Desc:
 * Author: Cheng
 * Date: 2016/4/21 0021
 */
public interface RpcHttpClientService {
    /**
     * GET请求
     * @param url
     * @return
     */
    String doGet(String url);

    /**
     * POST 请求
     * @param url 传入的微信地址
     * @param data 需要发送的JSON参数
     * @return 微信回复的消息
     */
    String doPost(String url, String data);
    /**
     * 发送媒体消息
     * @param url 传入的微信地址
     * @param path 需要传入的媒体文件
     * @return 返回的结果
     */
    String postMedia(String url, String path);
    /**
     * 根据媒体ID下载媒体资源
     * @param url
     * @param path
     */
    void getMidie(String url, String path);
}
