package com.example.lwlwebsocket.vo;

import com.example.lwlwebsocket.entity.Chats;
import com.example.lwlwebsocket.entity.History;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageEntity {

//    // 发送者的 id
//    private Long from;
//    // 接受者的 id
//    private Long to;
//    // 具体信息
//    private String message;
//    // 发送时间
//    private Date time;
//
    //聊天信息
    private Chats chats;

    private Chats chatsfrom;

    private ChatVo chatVo;

    private Message message;

    private History history;


}
