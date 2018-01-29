package com.jxau.kknq.Rest;

import com.jxau.kknq.Entity.Users;
import com.jxau.kknq.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        user.setUserName("罗文彬");
        user.setAddress("宝安区安顺路");
        user.setRegisterTime(new Date());
        user.setTelPhone("15579653329");
        return userRepository.save(user);
    }

    @GetMapping(value ="/hello")
    public String sayHello(){
        return "Hello SpringBoot!!";
    }
}
