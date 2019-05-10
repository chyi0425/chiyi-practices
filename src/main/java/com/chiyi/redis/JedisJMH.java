package com.chiyi.redis;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import redis.clients.jedis.Jedis;

import java.util.concurrent.TimeUnit;

/**
 * @author chiyi
 * @date 2019/5/10.
 */
@BenchmarkMode(Mode.Throughput)
@Warmup
@Threads(100)
@State(Scope.Thread)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class JedisJMH {
    private static final int LOOP = 100;
    private Jedis jedis;

    @Setup
    public void setup() {
        jedis = new Jedis("10.117.21.32", 6379);
    }

    @Benchmark
    public void jedisGet() {
        for (int i = 0; i < LOOP; ++i) {
            jedis.get("a");
        }
    }


    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().include(JedisJMH.class.getSimpleName()).forks(1).build();
        new Runner(options).run();
    }
}
