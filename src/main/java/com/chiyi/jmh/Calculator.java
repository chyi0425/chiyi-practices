package com.chiyi.jmh;

/**
 * @author chiyi
 * @date 2019/4/26.
 */
public interface Calculator {
    /**
     * calculate sum of an integer array
     *
     * @param numbers
     * @return
     */
    public long sum(int[] numbers);

    /**
     * shutdown pool or reclaim any related resources
     */
    public void shutdown();
}