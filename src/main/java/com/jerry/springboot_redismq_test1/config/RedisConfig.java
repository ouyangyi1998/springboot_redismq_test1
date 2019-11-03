package com.jerry.springboot_redismq_test1.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {
    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;
    @Value("${spring.redis.jedis.pool.max-active}")
    private int maxACTIVE;
    @Value("${spring.redis.jedis.pool.max-idle}")
    private int maxIdle;
    @Value("${spring.redis.jedis.pool.min-idle}")
    private int minIdle;
    @Value("${spring.redis.database}")
    private int database;
    @Value("${spring.redis.timeout}")
    private int timeout;
    @Bean
    public JedisPoolConfig jedisPoolConfig()
    {
        JedisPoolConfig config=new JedisPoolConfig();
        config.setMaxIdle(maxIdle);
        config.setMinIdle(minIdle);
        config.setMaxTotal(maxACTIVE);
        return config;

    }
    @Bean
    public JedisConnectionFactory jedisConnectionFactory()
    {
        JedisConnectionFactory factory=new JedisConnectionFactory();
        factory.setHostName(host);
        factory.setPort(port);
        factory.setPassword(null);
        factory.setDatabase(database);
        JedisPoolConfig config=jedisPoolConfig();
        factory.setPoolConfig(config);
        return factory;
    }
    @Bean
    public RedisTemplate<?,?> getRedisTemplate()
    {
        JedisConnectionFactory factory=jedisConnectionFactory();
        RedisTemplate<?,?> redisTemplate=new StringRedisTemplate(factory);
        return redisTemplate;
    }
}
