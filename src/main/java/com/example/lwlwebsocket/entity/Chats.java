package com.example.lwlwebsocket.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Chats {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private String type;

    private String online;

    private String avatar;

    private Integer userid;

    private Integer fromid;
}
