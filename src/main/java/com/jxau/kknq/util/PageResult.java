package com.jxau.kknq.util;

import org.springframework.data.domain.Page;

/**
 * 分页 Result
 * 
 * @author zhangdongliang
 * @email zhangdongliang@hey900.com
 * @date 2017-12-02 12:32
 */
public class PageResult<T> extends Result<T> {
    /**
     * 总页数
     */
    private long totalPage;
    /**
     * 当前页
     */
    private long currPage;
    /**
     * 总条数
     */
    private long totalSize;
    /**
     * 当前页条数
     */
    private long currSize;
    /**
     * 是否有下一页
     */
    private boolean hasNext;

    public PageResult(int statusCode, String msg, T data) {
        super(statusCode, msg, data);
    }

    public PageResult(int statusCode, String msg) {
        super(statusCode, msg);
    }

    public PageResult(int statusCode, String msg, T data, Page<?> page) {
        super(statusCode, msg, data);
        currSize = page.getNumberOfElements();
        currPage = page.getNumber() + 1;
        totalPage = page.getTotalPages();
        totalSize = page.getTotalElements();
        hasNext = page.hasNext();
    }
    public static <T> PageResult<T> SuccPageResult(T data) {
        return new PageResult<>(SUCC, Result.DEFAULT_SUCC_MESSAGE, data);
    }
    
    public static <T> PageResult<T> SuccPageResult() {
        return new PageResult<>(SUCC, Result.DEFAULT_SUCC_MESSAGE);
    }

    public static <T> PageResult<T> SuccPageResult(T data, Page<?> page) {
        if (page == null) {
            return new PageResult<>(SUCC, Result.DEFAULT_SUCC_MESSAGE, data);
        }
        return new PageResult<>(SUCC, Result.DEFAULT_SUCC_MESSAGE, data, page);
    }

    public static <T> PageResult<T> SuccPageResult(String msg) {
        return new PageResult<>(SUCC, msg);
    }
    
    public static <T> PageResult<T> FaildPageResult(String msg) {
        return new PageResult<>(SUCC, msg);
    }
    
    public static <T> PageResult<T> FaildPageResult() {
        return new PageResult<>(FAILED, Result.DEFAULT_FAILED_MESSAGE);
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public long getCurrPage() {
        return currPage;
    }

    public void setCurrPage(long currPage) {
        this.currPage = currPage;
    }

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }

    public long getCurrSize() {
        return currSize;
    }

    public void setCurrSize(long currSize) {
        this.currSize = currSize;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }
}
