package com.example.lwlwebsocket.vo;

import com.example.lwlwebsocket.vo.MessageEntity;
import com.google.gson.GsonBuilder;

import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class MessageEntityEncode implements Encoder.Text<MessageEntity> {

    @Override
    public String encode(MessageEntity messageEntity) {
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create()
                .toJson(messageEntity);
    }

    @Override
    public void init(EndpointConfig endpointConfig) {}

    @Override
    public void destroy() {}

}
