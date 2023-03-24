package com.example.lwlwebsocket.controller;

import com.example.lwlwebsocket.entity.User;
import com.example.lwlwebsocket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetFriendsController {

    private final UserService userService;

    @Autowired
    public GetFriendsController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/getFriends")
    public List<User> getFriends(@RequestParam("id") Long uid) {
        return userService.getFriends(uid);
    }

}

