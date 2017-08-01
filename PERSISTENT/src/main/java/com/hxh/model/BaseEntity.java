package com.hxh.model;

import java.io.Serializable;


public class BaseEntity implements Serializable {


    public static final int PER_PAGE_SIZE_10 = 10;// 默认10

    public static final int PER_PAGE_SIZE_20 = 20;

    public static final int DEFAULT_PER_PAGE_SIZE = PER_PAGE_SIZE_10;

    protected int dataCount = 0; // 总记录数

    protected int pageSize = DEFAULT_PER_PAGE_SIZE; // 每页显示的记录数

    protected int pageNo = 1; // 当前页

    protected int startRecord = 0; // 记录起始点

    protected int pageCount = 0; // 总页数

    protected String sortStr; //排序条件

    protected int stepSize;//步长


    public int getDataCount() {
        return dataCount;
    }

    public void setDataCount(int dataCount) {
        this.dataCount = dataCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getStartRecord() {
        return startRecord;
    }

    public void setStartRecord(int startRecord) {
        this.startRecord = startRecord;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getSortStr() {
        return sortStr;
    }

    public void setSortStr(String sortStr) {
        this.sortStr = sortStr;
    }

    public int getStepSize() {
        return stepSize;
    }

    public void setStepSize(int stepSize) {
        this.stepSize = stepSize;
    }
}