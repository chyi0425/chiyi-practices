package com.chiyi.redis;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisFuture;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisAsyncCommands;
import io.lettuce.core.api.sync.RedisCommands;

import java.util.Map;
import java.util.concurrent.ExecutionException;

public class UseLettuce {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        connectWithRedisURI1();
//        connectWithRedisURI2();
        connectWithRedisClient();
    }

    public static void connectWithRedisURI1() throws ExecutionException, InterruptedException {
        RedisURI redisURI = new RedisURI();
        redisURI.setHost("10.1.51.19");
        redisURI.setPort(6379);
        RedisClient redisClient = RedisClient.create(redisURI);
        syncTest(redisClient);
    }

    private static void syncTest(RedisClient redisClient) {
        StatefulRedisConnection<String, String> connection = redisClient.connect();
        RedisCommands<String, String> redisCommands = connection.sync();
        String value = redisCommands.get("100848");
        System.out.println(value);
        redisCommands.hset("recordName","FirstName","John");
        redisCommands.hset("recordName","LastName","Smith");
        Map<String,String> record = redisCommands.hgetall("recordName");
        record.entrySet();
    }

    private static void asyncTest(RedisClient redisClient) {
        
    }

    public static void connectWithRedisURI2() {
        RedisURI redisURI = RedisURI.Builder.redis("10.1.51.19", 6379).build();
        RedisClient redisClient = RedisClient.create(redisURI);
        syncTest(redisClient);
    }

    public static void connectWithRedisClient() {
        RedisClient redisClient = RedisClient.create("redis://10.1.51.19:6379");
        syncTest(redisClient);
    }
}
