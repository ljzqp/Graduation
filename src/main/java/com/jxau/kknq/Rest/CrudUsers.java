package com.jxau.kknq.Rest;

import com.jxau.kknq.Entity.Users;
import com.jxau.kknq.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class CrudUsers {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/getUsers")
    public List<Users> getUsers(){
        return userRepository.findAll();
    }

    @PostMapping(value = "/addUsers")
    public Users addUser(){
        Users user = new Users();
        user.setAge(19);
        user.setUserName("罗健");
        user.setAddress("吉安市青原区");
        user.setBirthday("1999-12-31");
        user.setSex("男");
        user.setRegisterTime(new Date());
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setTelPhone("15575681125");
        return userRepository.save(user);
    }

    @GetMapping(value ="/hello")
    public String sayHello(){
        return "Hello SpringBoot!!";
    }
}
