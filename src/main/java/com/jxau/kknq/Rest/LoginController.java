package com.jxau.kknq.rest;

import com.jxau.kknq.entity.Result;
import com.jxau.kknq.service.LoginService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author luowenbin
 * @email luowenbin@hey900.com
 * @date 2018/1/29 15:39
 */
@Controller
public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/index" , method = RequestMethod.GET)
    public String index(){
        return  "index";
    }


    @RequestMapping(value = "/qcart" , method = RequestMethod.GET)
    public String cart(){
        return  "payCart";
    }


    @PostMapping(value = "/login")
    public String login(HttpServletRequest request,
                        HttpServletResponse response,
                        Model model){
        String method = request.getMethod(); // 获取请求方式，get或post
        if("GET".equals(method)){
            return "login";
        }else if ("POST".equals(method)){
            String telPhone = request.getParameter("telPhone"); // 获取用户登陆电话
            String password = request.getParameter("password"); // 获取用户密码
            return loginService.login(telPhone,password,request,model);
        }
        return "login";
    }

    @RequestMapping(value = "/login" , method = RequestMethod.GET)
    public String login(){
        return  "login";
    }


    @RequestMapping(value = "/login/test", method = RequestMethod.GET)
    @ResponseBody
    public Result loginTest(HttpServletRequest request) {
        System.out.println("------------loginTest-----------");
        String username = request.getParameter("uname");
        String password = request.getParameter("upwd");
        System.out.println("nananan"+username);
        System.out.println("seefefefe"+password);
       int status = loginService.loginCheck(username,password);
        return new Result(status);
    }

//    @GetMapping(value = "/register")
//    public String register(HttpServletRequest request){
//        System.out.println(request.getAttribute("telPhone"));
//        return "!";
//    }

    private Logger logger = LoggerFactory.getLogger(LoginController.class);
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
