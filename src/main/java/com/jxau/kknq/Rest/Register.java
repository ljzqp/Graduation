package com.jxau.kknq.Rest;

import com.jxau.kknq.Entity.Users;

import org.springframework.stereotype.Controller;
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
public class Register {

    @PostMapping(value = "/register")
    public String register(HttpServletRequest request, HttpServletResponse response) {
        String tel = request.getParameter("tel");
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

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register(){
        return "/register";
    }
}
