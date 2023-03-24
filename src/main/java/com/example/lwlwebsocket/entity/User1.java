package com.example.lwlwebsocket.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class User1 {


    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;
    private String online;
    private String type;
    private String avatar;
    private String role;
}
