package com.jxau.kknq.rest;

import com.jxau.kknq.entity.Users;
import com.jxau.kknq.repository.UserRepository;
import com.jxau.kknq.service.RegisterService;
import com.jxau.kknq.service.SendMailService;
import com.jxau.kknq.util.EmailUtil;
import com.jxau.kknq.util.RandomUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
    SendMailService sendMailService;

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
            System.out.println("验证码为："+registerCode);
        return registerService.register(email,code,name,registerCode,request);
        }
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(HttpSession session, HttpServletRequest request){
        System.out.println("asasas");
        return "index";
    }

    @RequestMapping(value = "/sendEmail",method = RequestMethod.GET)
    public @ResponseBody String sendMail(String email,HttpServletRequest request,HttpSession session){
        System.out.println("I am coming");
        String code = RandomUtil.randomCode(); // 生成验证码
        System.out.println("生成的验证码"+code);
        request.getSession().setAttribute("registerCode",code);
//        String email = request.getParameter("email"); // 邮箱地址
        String name = request.getParameter("name"); // 用户昵称
        String name1 = session.getAttribute("name").toString(); // 用户昵称
        System.out.println("name+"+name);
        System.out.println("name1+"+name1);
        System.out.println("email+"+email);
        sendMailService.sendMail(name,email,code);
        System.out.println(code);
        return "1";
    }

//    @RequestMapping(value = "/sendEmail", method = RequestMethod.GET)
//    public @ResponseBody String sendMail(){
//        System.out.println("发送验证码");
//        return "1";
//    }
}
