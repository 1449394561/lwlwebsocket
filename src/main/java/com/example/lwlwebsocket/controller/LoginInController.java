package com.example.lwlwebsocket.controller;

import com.example.lwlwebsocket.entity.LoginEntity;
import com.example.lwlwebsocket.entity.User;
import com.example.lwlwebsocket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginInController {

    private final UserService userService;

    @Autowired
    public LoginInController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public User login(@RequestBody LoginEntity loginEntity) {
        return userService.findByUsernameAndPassword(loginEntity.getUsername(), loginEntity.getPassword());
    }

}

