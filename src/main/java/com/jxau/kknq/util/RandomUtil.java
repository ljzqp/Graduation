package com.jxau.kknq.util;

/**
 * @author luowenbin
 * @email luowenbin@hey900.com
 * @date 2018/2/1 14:24
 */
public class RandomUtil {
    /** 随机6位数 */
    public static String randomCode() {
        Integer res = (int)(Math.random()*1000000);
        return res+"";
    }
}
