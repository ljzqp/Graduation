package com.jxau.kknq.exception;

/**
 * @author luowenbin
 * @email luowenbin@hey900.com
 * @date 2018/2/1 14:07
 */
public class SystemException extends RuntimeException{
    private static final long serialVersionUID = -4555331337009026323L;

    public SystemException() {
        super();
    }

    public SystemException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public SystemException(String msg) {
        super(msg);
    }

    public SystemException(Throwable throwable) {
        super(throwable);
    }
}
