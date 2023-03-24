package com.example.lwlwebsocket.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.lwlwebsocket.dao.ChatsMapper;
import com.example.lwlwebsocket.entity.Chats;
import com.example.lwlwebsocket.entity.User;
import com.example.lwlwebsocket.service.UserService;
import com.example.lwlwebsocket.vo.ChatVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class GetFriendsController {

    private final UserService userService;

    @Autowired
    public ChatsMapper chatsMapper;

    @Autowired
    public GetFriendsController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/getFriends")
    public List<User> getFriends(@RequestParam("id") Long uid) {
        return userService.getFriends(uid);
    }

    @PostMapping("/chats")
    public List<ChatVo> Friends(@RequestParam("id") Integer userid) {
        QueryWrapper<Chats> wrapper = new QueryWrapper();
        wrapper.eq("userid",userid);
        List<Chats> chats1 = chatsMapper.selectList(wrapper);
        List<ChatVo> chats=new LinkedList<>();

        for (Chats c:chats1){
            ChatVo chatVo=new ChatVo();
            chatVo.setId(c.getFromid());
            chatVo.setName(c.getName());
            chatVo.setType(c.getType());
            chatVo.setOnline(c.getOnline());
            chatVo.setAvatar(c.getAvatar());
            chats.add(chatVo);
        }
        return chats;
    }


    @GetMapping("/addchat")
    public String addchat(@RequestParam("id") Integer userid){
        Chats chat=new Chats();
        chat.setFromid(1);
        chat.setType("friend");
        chat.setUserid(userid);
        chat.setOnline("true");
        chat.setName("联运客服一");
        chatsMapper.insert(chat);


        Chats chat1=new Chats();
        chat1.setFromid(userid);
        chat1.setType("friend");
        chat1.setUserid(1);
        chat1.setOnline("true");
        chat1.setName("客户一");
        chatsMapper.insert(chat1);
        return "200";

    }

//    @GetMapping("/rechat")
//    public List<ChatVo> rechat(@RequestParam("id") Integer userid,@RequestParam("len") Integer len){
//        QueryWrapper<Chats> wrapper = new QueryWrapper();
//        wrapper.eq("userid", userid).orderByAsc("id").last("limit 2");
//
//    }
}

