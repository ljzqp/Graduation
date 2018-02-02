package com.jxau.kknq.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 安全工具类，可以进行数据的加密和解密，并且可以完成对象的加密和解密
 * @author luowenbin
 * @email luowenbin@hey900.com
 * @date 2018/2/1 10:01
 */
@SuppressWarnings("rawtypes")
public class SecurityUtil {
	public static String md5(String password) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
		return new BigInteger(1,md.digest()).toString(16);
	}
	
	public static String md5(String tel,String password) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(tel.getBytes());
		md.update(password.getBytes());
		return new BigInteger(1,md.digest()).toString(16);
	}
}
