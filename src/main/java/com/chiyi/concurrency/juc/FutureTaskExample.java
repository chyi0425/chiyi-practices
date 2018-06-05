package com.chiyi.concurrency.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 在介绍 Callable 时我们知道它可以有返回值，返回值通过 Future 进行封装。
 * FutureTask 实现了 RunnableFuture 接口，该接口继承自 Runnable 和 Future 接口，
 * 这使得 FutureTask 既可以当做一个任务执行，也可以有返回值。
 *
 * 当一个计算任务需要执行很长时间，那么就可以用 FutureTask 来封装这个任务，
 * 用一个线程去执行该任务，然后其它线程继续执行其它任务。当需要该任务的计算结果时，再通过 FutureTask 的 get() 方法获取。
 */
public class FutureTaskExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int result = 0;
                for (int i = 0; i < 100; i++) {
                    Thread.sleep(10);
                    result += i;
                }
                return result;
            }
        });

        Thread computeThread = new Thread(futureTask);
        computeThread.start();

        Thread otherThread = new Thread(()->{
            System.out.println("other task is running...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        otherThread.start();
        System.out.println(futureTask.get());
    }
}
