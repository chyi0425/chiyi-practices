package com.chiyi.redis;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import redis.clients.jedis.Jedis;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 1)
@Threads(100)
@State(Scope.Thread)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class JedisJMH {
    private static final int LOOP = 100;
    private Jedis jedis;
    @Setup
    public void setup() {
        jedis = new Jedis("127.0.0.1", 6379);
    }
    @Benchmark
    public void get() {
        for (int i = 0; i < LOOP; ++i) {
            jedis.get("a");
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder().include(JedisJMH.class.getSimpleName()).forks(1).warmupIterations(5).measurementIterations(5).build();

        new Runner(opt).run();
//        Benchmark      Mode  Cnt   Score   Error   Units
//        JedisJMH.get  thrpt    5  43.182 ± 3.361  ops/ms

    }
}
