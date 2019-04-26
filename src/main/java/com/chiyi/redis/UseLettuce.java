package com.chiyi.redis;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisFuture;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisAsyncCommands;
import io.lettuce.core.api.sync.RedisCommands;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public class UseLettuce {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        connectWithRedisURI1();
//        connectWithRedisURI2();
//        connectWithRedisClient();
        connectAsynWithRedisClient();
    }

    public static void connectWithRedisURI1() throws ExecutionException, InterruptedException {
        RedisURI redisURI = new RedisURI();
        redisURI.setHost("10.117.21.32");
        redisURI.setPort(6379);
        redisURI.setPassword("1234");
        RedisClient redisClient = RedisClient.create(redisURI);
        syncTest(redisClient.connect());
    }

    private static void syncTest(StatefulRedisConnection<String, String> connection) {
        RedisCommands<String, String> redisCommands = connection.sync();
        String value = redisCommands.get("100848");
        System.out.println(value);
        redisCommands.hset("recordName","FirstName","John");
        redisCommands.hset("recordName","LastName","Smith");
        Map<String,String> record = redisCommands.hgetall("recordName");
        record.entrySet();
    }

    private static void asyncTest(StatefulRedisConnection<String, String> connection) throws ExecutionException, InterruptedException {
        RedisAsyncCommands<String, String> asyncCommands = connection.async();
        RedisFuture<String> result = asyncCommands.get("100848");
//        RedisStringReactiveCommands<String, String> reactiveCommands = connection.reactive();
        asyncCommands.lpush("tasks","firstTask");
        asyncCommands.lpush("tasks","secondTask");
        RedisFuture<String> redisFuture = asyncCommands.rpop("tasks");
        String nextTask = redisFuture.get();
        System.out.println(nextTask);
        asyncCommands.sadd("pets", "dog");
        asyncCommands.sadd("pets", "cat");
        asyncCommands.sadd("pets", "cat");
        RedisFuture<Set<String>> pets = asyncCommands.smembers("nicknames");
        RedisFuture<Boolean> exists = asyncCommands.sismember("pets", "dog");
    }

    public static void connectWithRedisURI2() {
        RedisURI redisURI = RedisURI.Builder.redis("10.1.51.19", 6379).build();
        RedisClient redisClient = RedisClient.create(redisURI);
        syncTest(redisClient.connect());
    }

    public static void connectWithRedisClient() {
        RedisClient redisClient = RedisClient.create("redis://10.1.51.19:6379");
        syncTest(redisClient.connect());
    }

    public static void connectAsynWithRedisClient() throws ExecutionException, InterruptedException {
        RedisURI redisURI = RedisURI.Builder.redis("10.117.21.32",6379).withPassword("1234").build();
        RedisClient redisClient = RedisClient.create(redisURI);
        asyncTest(redisClient.connect());
    }
}
