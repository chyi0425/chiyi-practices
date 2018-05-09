package com.chiyi.concurrency.interrupted;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorInterruptExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    System.out.println("Thread run");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        executorService.shutdownNow();
        System.out.println("Main run");
    }
}
