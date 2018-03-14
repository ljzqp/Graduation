package com.jxau.kknq.service.impl;

import com.jxau.kknq.Entity.Users;
import com.jxau.kknq.exception.SystemException;
import com.jxau.kknq.Repository.UserRepository;
import com.jxau.kknq.service.LoginService;
import com.jxau.kknq.util.SecurityUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author luowenbin
 * @email luowenbin@hey900.com
 * @date 2018/2/1 10:01
 */
@Service("LoginService")
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public String login(String telPhone, String password, HttpServletRequest request, Model model) {
        String errMsg = null;
        Users user;
        user = userRepository.getUsersByTelPhoneAndPassword(telPhone, password);
        try {
            if (user == null || user.getStatus() != 1) {
                errMsg = telPhone + "不存在或已停用";
            } else if (!user.getPassword().equals(SecurityUtil.md5(telPhone, password))) {
                errMsg = "密码输入不正确";
            } else {
                request.getSession().setAttribute("username", telPhone);
            }
            if (errMsg != null && !"".equals(errMsg)) {
                model.addAttribute("errMsg", errMsg);
                return "error";
            } else {
                return "redirect:/mainPage";
            }
        } catch (NoSuchAlgorithmException e) {
            throw new SystemException("登陆异常");
        }
    }

    @Override
    public int loginCheck(String username, String password) {
        Users user;
        user = userRepository.getUsersByUsername(username, password);

        if (user != null && user.getStatus() !=1){
            return 1001;
        }
        else{
            return 1000;
        }



    }


}
