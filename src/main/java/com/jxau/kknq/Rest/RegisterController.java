package com.jxau.kknq.rest;

import com.jxau.kknq.entity.Users;
import com.jxau.kknq.repository.UserRepository;
import com.jxau.kknq.service.RegisterService;
import com.jxau.kknq.util.EmailUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author luowenbin
 * @email luowenbin@hey900.com
 * @date 2018/1/31 14:33
 */
@Controller
public class RegisterController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RegisterService registerService;

    @Autowired
    EmailUtil emailUtil;

    @PostMapping(value = "/dregister")
    public String register(HttpServletRequest request, HttpServletResponse response) {
        String tel = request.getParameter("telPhone");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        if (password1 != null && password2 != null && password1.equals(password2)) {
            Users user = new Users();
            user.setTelPhone(tel);
            user.setPassword(password1);
            return "login";
        }
        return "error";
    }

    @PostMapping(value = "/register")
    public String register(Model model, HttpServletRequest request) {
        String email = request.getParameter("email"); //邮箱地址
        String code = request.getParameter("code"); //验证码
        String name = request.getParameter("name"); //用户昵称
        String registerCode;
        String method = request.getMethod();
        System.out.println("sssss");
        if("GET".equals(method)){
            return "register";
        }else if ("POST".equals(method)){
            registerCode = (String) request.getSession().getAttribute("registerCode");
        return registerService.register(email,code,name,registerCode,request);
        }
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(){
        System.out.println("asasas");
        return "ss";
    }

    @RequestMapping(value = "/sendEmail",method = RequestMethod.POST)
    public String sendMail(){
        return "下班";
    }
}
