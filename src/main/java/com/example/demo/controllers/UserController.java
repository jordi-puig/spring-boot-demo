package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/create/")
    public User convert(@PathVariable(name = "user.name") User user) {
        return userService.create(user);
    }

}
