package com.example.lwlwebsocket.service;

import com.example.lwlwebsocket.dao.UserDao;
import com.example.lwlwebsocket.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@Service
public class UserService {

    private final UserDao dao;

    @Autowired
    public UserService(UserDao dao) {
        this.dao = dao;
    }

    public User findById(Long uid) {
        return dao.findById(uid).orElse(null);
    }

    public User findByUsernameAndPassword(String username, String password) {
        return dao.findByUsernameAndPassword(username, password);
    }

    public List<User> getFriends(Long uid) {
        // 这里为了简化整个程序，就在这里模拟用户获取好友列表的操作
        // 就不通过数据库来存储好友关系了
        return LongStream.of(1L, 2L, 3L, 4L,5L,6L)
                .filter(item -> item != uid)
                .mapToObj(this::findById)
                .collect(Collectors.toList());
    }

}

