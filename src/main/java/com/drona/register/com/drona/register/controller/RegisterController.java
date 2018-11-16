package com.drona.register.com.drona.register.controller;

import com.drona.register.com.drona.register.pojo.Response;
import com.drona.register.com.drona.register.pojo.User;
import com.drona.register.com.drona.register.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class RegisterController {
    @Autowired
    RegisterService registerService;
    @GetMapping(value = "users")
    public String sample(){
        return "Am here";
    }
    @PostMapping(value = "addUser")
    public Response addUser(@RequestBody User user){
        return registerService.addUser(user);
    }
}
