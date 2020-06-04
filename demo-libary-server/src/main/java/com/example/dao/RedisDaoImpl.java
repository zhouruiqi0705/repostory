package com.example.dao;

import io.lettuce.core.api.reactive.RedisStringReactiveCommands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class RedisDaoImpl implements RedisDao {
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Override
    public Integer setAdd(String key, String value) {
        return redisTemplate.opsForSet().add(key,value).intValue();
    }

    @Override
    public void expireat(String key,long time) {
        redisTemplate.expire(key,time, TimeUnit.MINUTES);
    }
}
