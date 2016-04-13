package com.cheng.weixin.service.wxtools.httputils;

import org.apache.http.conn.HttpClientConnectionManager;

/**
 * Desc: 关闭无效的连接
 * Author: Cheng
 * Date: 2016/4/13 0013
 */
public class ClientEvictExpiredConnections extends Thread {
    private final HttpClientConnectionManager connMgr;

    private volatile boolean shutdown;

    public ClientEvictExpiredConnections(HttpClientConnectionManager connMgr) {
        this.connMgr = connMgr;
    }
    @Override
    public void run() {
        try {
            while (!shutdown) {
                synchronized (this) {
                    wait(5000);
                    // 关闭失效的连接
                    connMgr.closeExpiredConnections();
                }
            }
        } catch (InterruptedException ex) {
            // 结束
        }
    }

    public void shutdown() {
        shutdown = true;
        synchronized (this) {
            notifyAll();
        }
    }

}
