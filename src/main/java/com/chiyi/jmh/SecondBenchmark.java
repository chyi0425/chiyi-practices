package com.chiyi.jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author chiyi
 * @date 2019/4/26.
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Benchmark)
public class SecondBenchmark {
    @Param({"10000", "100000", "1000000"})
    private int length;

    private int[] numbers;
    private Calculator singleThreadCalc;
    private Calculator multiThreadCalc;

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(SecondBenchmark.class.getSimpleName())
                .forks(2)
                .warmupIterations(5)
                .measurementIterations(5)
                .build();
        new Runner(opt).run();
    }

    @Benchmark
    public long singleThreadBench(){
        return singleThreadCalc.sum(numbers);
    }

    @Benchmark
    public long multiThreadBench(){
        return multiThreadCalc.sum(numbers);
    }

    @Setup
    public void prepare(){
        numbers = IntStream.rangeClosed(1,length).toArray();
        singleThreadCalc = new SinglethreadCalculator();
        System.out.println(Runtime.getRuntime().availableProcessors());
        multiThreadCalc = new MultithreadCacculator(Runtime.getRuntime().availableProcessors());
    }

    @TearDown
    public void shutdown(){
        singleThreadCalc.shutdown();
        multiThreadCalc.shutdown();
    }
}
