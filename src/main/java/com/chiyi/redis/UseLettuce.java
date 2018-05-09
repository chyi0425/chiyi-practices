package com.chiyi.redis;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

public class UseLettuce {
    public static void main(String[] args) {

        RedisURI redisURI = new RedisURI();
        redisURI.setHost("10.1.51.19");
        redisURI.setPort(6379);
        RedisClient redisClient = RedisClient.create(redisURI);
        StatefulRedisConnection<String,String> connection = redisClient.connect();
        RedisCommands<String,String> redisCommands = connection.sync();
        String value = redisCommands.get("100848");
    }
}
