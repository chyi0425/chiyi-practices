package com.chiyi.concurrency.test;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author chiyi
 */
public class Runner implements Runnable {
    private int number;
    private CyclicBarrier cyclicBarrier;

    public Runner(int i, CyclicBarrier cyclicBarrier) {
        this.number = i;
        this.cyclicBarrier = cyclicBarrier;
    }

    public void run() {
        try {
            int timer = new Random().nextInt(5);
            TimeUnit.SECONDS.sleep(timer);
            System.out.printf("%d号选手准备完毕，准备时间%d\n",number,timer);
            cyclicBarrier.await();
            System.out.printf("%d号选手于%s时起跑!\n",number,new Date().toString());
        }catch (InterruptedException|BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
