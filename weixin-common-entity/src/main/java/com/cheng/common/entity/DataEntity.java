package com.cheng.common.entity;


import com.cheng.common.entity.id.IdGen;
import com.cheng.common.entity.enums.Status;

import java.util.Date;

/**
 * Desc: 数据Entity类
 * Author: 光灿
 * Date: 2016/2/27
 */
public abstract class DataEntity<T> extends BaseEntity<T> {

    /** 备注 **/
    protected String remarks;
    /** 创建时间 **/
    protected Date createDate;
    /** 更新时间 **/
    protected Date updateDate;
    /** 状态 **/
    protected Status status;

    public DataEntity() {
        super();
        this.status = Status.NORMAL;
    }

    /**
     * 更新之前需要手动调用
     */
    @Override
    public void preUpdate() {
        this.updateDate = new Date();
    }

    /**
     * 插入之前执行 需要手动调用
     */
    @Override
    public void preInsert() {
        if (isNewRecord) {
            setId(IdGen.uuid());
        }
        this.createDate = new Date();
        this.updateDate = new Date();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
