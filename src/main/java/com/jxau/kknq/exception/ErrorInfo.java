package com.jxau.kknq.exception;

/**
 * @author luowenbin
 * @email luowenbin@hey900.com
 * @date 2018/2/1 10:01
 */
public class ErrorInfo<T> {
    public static final String OK = "0";
    public static  final String ERROR = "-1";

    private String code;
    private String message;
    private String url;
    private String params;
    private T datas;

    public String getCode() {
        return code;
    }

    public String getParams() {
        return params;
    }

    public String getMessage() {
        return message;
    }

    public String getUrl() {
        return url;
    }

    public T getDatas() {
        return datas;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDatas(T datas) {
        this.datas = datas;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
