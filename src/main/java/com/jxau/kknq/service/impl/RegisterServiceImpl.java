package com.jxau.kknq.service.impl;

import com.jxau.kknq.entity.Users;
import com.jxau.kknq.exception.SystemException;
import com.jxau.kknq.repository.UserRepository;
import com.jxau.kknq.service.RegisterService;
import com.jxau.kknq.util.EmailUtil;
import com.jxau.kknq.util.RandomUtil;
import com.jxau.kknq.util.RequestUtil;
import com.jxau.kknq.util.SecurityUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

/**
 * @author luowenbin
 * @email luowenbin@hey900.com
 * @date 2018/2/1 10:02
 */
@Service("RegisterService")
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    EmailUtil emailUtil;
    @Override
    public String register(String email, String code, String name, String registerCode, HttpServletRequest request) {
        Users user = userRepository.findByEmail(email);
        if(user!=null) {
            throw new SystemException("邮箱地址【"+email+"】已经存在。如果忘记密码请<a href='/findPwd'>找回密码</a>");
        } else if(!registerCode.equalsIgnoreCase(code)) {
            throw new SystemException("邮箱验证码输入错误！");
        } else {
            String randomCode = RandomUtil.randomCode(); //随机密码
            user = new Users();
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            user.setEmail(email);
            user.setUsername(name);
            user.setRegisterTime(new Date());
            user.setRegisterType(1);
            try {
                user.setPassword(SecurityUtil.md5(email, randomCode));
            } catch (NoSuchAlgorithmException e) {
            }
            user.setStatus(0);
            userRepository.save(user);
            emailUtil.sendRegisterSuc(email, randomCode, RequestUtil.getCurUrl(request)+"/web/login");
            emailUtil.sendOnRegister(RequestUtil.getAdminEmail(request), name, email, "#");
        }
        return "redirect:/login";
    }
}
