package com.example.dao;

public interface RedisDao {
    public Integer setAdd(String key, String value);
    public void expireat(String key,long time);
}
