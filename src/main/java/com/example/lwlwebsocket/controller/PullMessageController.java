package com.example.lwlwebsocket.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.lwlwebsocket.dao.HistoryMapper;
import com.example.lwlwebsocket.entity.Chats;
import com.example.lwlwebsocket.entity.History;
import com.example.lwlwebsocket.utils.RedisUtil;
import com.example.lwlwebsocket.vo.HistoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@RestController
public class PullMessageController {

    @Autowired
    private HistoryMapper historyMapper;

    private final RedisUtil redis;

    @Autowired
    public PullMessageController(RedisUtil redis) {
        this.redis = redis;
    }

    @PostMapping("/histories")
    public List<HistoryVo> histories(@RequestParam("from") Long from, @RequestParam("to") Long to){
        QueryWrapper<History> wrapper = new QueryWrapper();
        wrapper.eq("fromid",from).eq("toid",to);
        List<History> histories = historyMapper.selectList(wrapper);



        //发给对面的
        List<HistoryVo> historyVos=new LinkedList<>();
        for (History history:histories){
            HistoryVo historyVo = new HistoryVo();
            historyVo.setUsername(history.getFromusername());
//            historyVo.setAvatar();
            historyVo.setId(history.getToid());
            historyVo.setType(history.getType());
            historyVo.setContent(history.getContent());
            historyVo.setCid(history.getCid());
            historyVo.setMine(true);
            historyVo.setFromid(history.getFromid());
            historyVo.setTimestamp(history.getTimestamp());
            historyVos.add(historyVo);
        }

        //对面发给我的
        QueryWrapper<History> wrapper1 = new QueryWrapper();
        wrapper1.eq("fromid",to).eq("toid",from);
        List<History> histories1 = historyMapper.selectList(wrapper1);
        List<HistoryVo> historyVos1=new LinkedList<>();
        for (History history:histories1){
            HistoryVo historyVo = new HistoryVo();
            historyVo.setUsername(history.getFromusername());
//            historyVo.setAvatar();
            historyVo.setId(history.getToid());
            historyVo.setType(history.getType());
            historyVo.setContent(history.getContent());
            historyVo.setCid(history.getCid());
            historyVo.setMine(false);
            historyVo.setFromid(history.getFromid());
            historyVo.setTimestamp(history.getTimestamp());
            historyVos1.add(historyVo);
        }


        List<HistoryVo> zhistoryVos=new LinkedList<>();
        zhistoryVos.addAll(historyVos);
        zhistoryVos.addAll(historyVos1);
        List<HistoryVo> collect1 = zhistoryVos.stream().sorted(Comparator.comparing(HistoryVo::getTimestamp).reversed()).collect(Collectors.toList());
        return collect1;
    }

    @PostMapping("/pullMsg")
    public List<Object> pullMsg(@RequestParam("from") Long from, @RequestParam("to") Long to) {
        // 根据两人的 id 生成键，并到 redis 中获取
        String key = LongStream.of(from, to)
                .sorted()
                .mapToObj(String::valueOf)
                .collect(Collectors.joining("-"));
        return redis.get(key);
    }

}

