package com.jxau.kknq.Rest;

import com.jxau.kknq.Entity.Users;
import com.jxau.kknq.Repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * @date 2018/1/29 15:39
 */
@Controller
public class Login {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/login")
    public String login(HttpServletRequest request,
            HttpServletResponse response){
        String telPhone = request.getParameter("tel");
        String password = request.getParameter("password");
       Users user = userRepository.getUsersByTelPhoneAndPassword(telPhone,password);
        if(user == null){
            return "error";
        }
        return "mainPage";
    }

    @RequestMapping(value = "/login" , method = RequestMethod.GET)
    public String login(){
        return  "login";
    }

//    @GetMapping(value = "/register")
//    public String register(HttpServletRequest request){
//        System.out.println(request.getAttribute("telPhone"));
//        return "!";
//    }

    private Logger logger = LoggerFactory.getLogger(Login.class);
    /**
     * 测试hello
     * @return
     */
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(Model model) {
        model.addAttribute("name", "Dear");
        return "hello";
    }

}
