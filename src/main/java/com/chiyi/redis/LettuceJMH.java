package com.chiyi.redis;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisFuture;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisAsyncCommands;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author chiyi
 * @date 2019/5/10.
 */


@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 1)
@Threads(100)
@State(Scope.Benchmark)
@Measurement(iterations = 2, time = 600, timeUnit = TimeUnit.MILLISECONDS)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class LettuceJMH {

    private static final int LOOP = 100;
    private StatefulRedisConnection<String, String> connection;

    @Setup
    public void setup() {
        RedisClient client = RedisClient.create("redis://10.10.10.230");
        connection = client.connect();
    }

    @Benchmark
    public void get() throws ExecutionException, InterruptedException {
        RedisAsyncCommands<String, String> commands = connection.async();
        List<RedisFuture<String>> redisFutureList = new ArrayList<>();
        for (int i = 0; i < LOOP; ++i) {
            RedisFuture<String> future = commands.get("a");
            redisFutureList.add(future);
            future.get();
        }
        redisFutureList.forEach(f -> {
            try {
                f.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().include(LettuceJMH.class.getSimpleName()).forks(1).warmupIterations(5).measurementIterations(5).build();
        new Runner(options).run();
    }
}

