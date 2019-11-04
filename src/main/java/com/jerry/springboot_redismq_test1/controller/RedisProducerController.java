package com.jerry.springboot_redismq_test1.controller;

import com.jerry.springboot_redismq_test1.config.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/producer")
public class RedisProducerController {
    @Autowired
    RedisClient redisClient;
    private final static String SUCCESS="success";
    private final static String MESSAGE="testmq";
    private final static List<String> list;

    static {
        list= Arrays.asList(new String[]{"jerry","action","sheva"});
    }
    @RequestMapping("/sendMsg")
    public String sendMsg()
    {
        for (String msg: list)
        {
            redisClient.lpush(MESSAGE,msg);
        }
        return SUCCESS;
    }
}
