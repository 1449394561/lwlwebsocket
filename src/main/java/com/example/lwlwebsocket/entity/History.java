package com.example.lwlwebsocket.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;


@Data
public class History {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String fromusername;

    private Integer toid;

    private String type;

    private String content;

    private Integer cid;

    private Integer fromid;

    private String timestamp;

    private String tousername;

}
