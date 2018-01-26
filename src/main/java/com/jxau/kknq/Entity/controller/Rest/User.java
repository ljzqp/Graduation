package com.jxau.kknq.Entity.controller.Rest;

import com.jxau.kknq.Entity.Hello;
import com.jxau.kknq.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class User {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/getUsers")
    public List<Hello> getUsers(){
        return userRepository.findAll();
    }

    @PostMapping(value = "/users")
    public Hello addUser(@RequestParam("age") Integer age,
                          @RequestParam("name") String name){
        Hello user = new Hello();
        user.setAge(age);
        user.setName(name);
        return userRepository.save(user);
    }
}
