package com.example.lwlwebsocket.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


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

//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") //前台传数据到后台
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")// 后台传数据到前台
    private Date timestamp;

    private String tousername;

}
