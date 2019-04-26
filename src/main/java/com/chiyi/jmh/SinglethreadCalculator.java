package com.chiyi.jmh;

/**
 * @author chiyi
 * @date 2019/4/26.
 */
public class SinglethreadCalculator implements Calculator {
    @Override
    public long sum(int[] numbers) {
        long total = 0L;
        for (int i : numbers) {
            total += i;
        }
        return total;
    }

    @Override
    public void shutdown() {

    }
}
