package com.jxau.kknq.Rest;

import com.jxau.kknq.Entity.Users;
import com.jxau.kknq.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author luowenbin
 * @email luowenbin@hey900.com
 * @date 2018/1/29 15:39
 */
@Controller
public class Login {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/login")
    public String login(@RequestParam String telPhone,
                        @RequestParam String password,
                        HttpServletRequest request){
        String userName = null;
        Users user = userRepository.getUsersByTelPhoneAndPassword(telPhone,password);
        if(user == null){
            return "账号密码错误";
        }
        request.setAttribute(telPhone,user.getTelPhone());
//        request.setAttribute(userName,user.getUserName());
        return "登陆成功!";
    }

    @GetMapping(value = "/register")
    public String register(HttpServletRequest request){
        System.out.println(request.getAttribute("telPhone"));
//        System.out.println(request.getAttribute("telPhone"));
        return "!";
    }

}
