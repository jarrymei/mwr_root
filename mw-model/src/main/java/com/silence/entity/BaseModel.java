package com.silence.entity;

import java.beans.Transient;

/**
 * Created by silence on 2018/4/8.
 */
public class BaseModel {

    private Integer pageNum = 1;
    private Integer pageSize = 10;

    public Integer getPageNum() {
        return pageNum;
    }

    @Transient
    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    @Transient
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
