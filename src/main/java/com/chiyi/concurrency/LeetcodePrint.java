package com.chiyi.concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author chiyi
 * @date 2019/8/29.
 */
public class LeetcodePrint {
    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(3, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r,"leetcode");
            }
        });
    }
}
