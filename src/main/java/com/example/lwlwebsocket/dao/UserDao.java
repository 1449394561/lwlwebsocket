package com.example.lwlwebsocket.dao;

import com.example.lwlwebsocket.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    User findByUsernameAndPassword(String userName, String password);

}
