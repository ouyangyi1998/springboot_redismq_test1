package com.jerry.springboot_redismq_test1.controller;

import com.jerry.springboot_redismq_test1.config.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/consumer")
public class RedisConsumerController {
    @Autowired
    RedisClient redisClient;
    private final static String MESSAGE="testmq";
    @RequestMapping("/receiveMsg")
    public String sendMsg()
    {
        return (String)redisClient.brpop(MESSAGE,0, TimeUnit.SECONDS);
    }
}
