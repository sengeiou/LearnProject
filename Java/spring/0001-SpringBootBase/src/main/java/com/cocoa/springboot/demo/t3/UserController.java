package com.cocoa.springboot.demo.t3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserServiceImpl userService;

    @RequestMapping("/find")
    public User getUser(){
        String name  = "cocoa";
        return  userService.findByName(name);
    }

}

