package com.jxau.kknq.util;

import java.io.Serializable;

/**
 * 通用返回客户端结果类
 * 
 * @author zhangdongliang
 * @email zhangdongliang@hey900.com
 * @date 2017-12-02 12:30
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final int SUCC = 0;
    public static final int FAILED = 1;

    public static final String DEFAULT_SUCC_MESSAGE = "成功";
    public static final String DEFAULT_FAILED_MESSAGE = "失败";

    private int statusCode = 0;
    private String msg;
    private T data;

    public Result() {

    }

    public Result(int statusCode, String msg) {
        this.statusCode = statusCode;
        this.msg = msg;
    }

    public Result(int statusCode, String msg, T data) {
        this.statusCode = statusCode;
        this.msg = msg;
        this.data = data;
    }

    public static <T> Result<T> SuccResult() {
        return new Result<>(SUCC, DEFAULT_SUCC_MESSAGE);
    }

    public static <T> Result<T> SuccResult(String msg) {
        return new Result<>(SUCC, msg);
    }

    public static <T> Result<T> SuccResult(T data) {
        return new Result<>(SUCC, DEFAULT_SUCC_MESSAGE, data);
    }

    public static <T> Result<T> SuccResult(String msg, T data) {
        return new Result<>(SUCC, msg, data);
    }

    public static <T> Result<T> FailedResult() {
        return new Result<>(FAILED, DEFAULT_FAILED_MESSAGE);
    }

    public static <T> Result<T> FailedResult(String msg) {
        return new Result<>(FAILED, msg);
    }

    public static <T> Result<T> FailedResult(T data) {
        return new Result<>(FAILED, DEFAULT_FAILED_MESSAGE, data);
    }

    public static <T> Result<T> FailedResult(String msg, T data) {
        return new Result<>(FAILED, msg, data);
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    // @Transient
    public boolean isSuccess() {
        return statusCode == 0;
    }
}
