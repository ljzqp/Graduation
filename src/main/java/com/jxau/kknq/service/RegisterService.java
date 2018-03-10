package com.jxau.kknq.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author luowenbin
 * @email luowenbin@hey900.com
 * @date 2018/2/1 10:01
 */
@Service
public interface RegisterService {
    String register(String email,String code,String name,String registerCode,HttpServletRequest request);
    int register(String username,String password,String birth,String address);
}
