package com.jxau.kknq.service;

import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

/**
 * @author luowenbin
 * @email luowenbin@hey900.com
 * @date 2018/2/1 10:01
 */
public interface LoginService {
    String login(String telPhone, String password, HttpServletRequest request,Model model);
}
