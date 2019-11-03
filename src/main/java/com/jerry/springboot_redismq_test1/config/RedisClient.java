package com.jerry.springboot_redismq_test1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class RedisClient {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    public boolean lpush(String key,Object value)
    {
        try{
            redisTemplate.opsForList().leftPush(key,value);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
    public Object rpop(String key)
    {
        try{
            return redisTemplate.opsForList().rightPop(key);
        }catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    public Object brpop(String key, long timeout, TimeUnit timeUnit)
    {
        try{
            return redisTemplate.opsForList().rightPop(key,timeout,timeUnit);
        }catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    public List<Object> lrange(String key,long start,long end)
    {
        try{
            return redisTemplate.opsForList().range(key,start,end);
        }catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
