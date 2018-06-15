package com.chiyi.concurrency.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 用来控制多个线程互相等待，只有当多个线程都到达时，这些线程才会继续执行。
 *  * 和 CountdownLatch 相似，都是通过维护计数器来实现的。但是它的计数器是递增的，
 *  每次执行 await() 方法之后，计数器会加 1，直到计数器的值和设置的值相等，
 *  等待的所有线程才会继续执行。和 CountdownLatch 的另一个区别是，
 *  CyclicBarrier 的计数器可以循环使用，所以它才叫做循环屏障。
 *
 */
public class CyclicBarrierExample {
    public static void main(String[] args) {
        final int totalThread = 10;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0;i< totalThread;i++){
            executorService.execute(()->{
                System.out.print("before..");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("after..");
            });
        }
        executorService.shutdown();
    }
}
