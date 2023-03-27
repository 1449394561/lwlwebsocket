package com.example.lwlwebsocket.vo;

import lombok.Data;

import java.util.Date;

@Data
public class HistoryVo {
    private String username;
    private String avatar;
    private Integer id;
    private String type;
    private String content;
    private Integer cid;
    private Boolean mine;
    private Integer fromid;
    private Date timestamp;

}
