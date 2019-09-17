package com.chiyi.concurrency;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author chiyi
 * @date 2019/8/29.
 */
public class ZeroEvenOdd {
    private Semaphore semaphore0 = new Semaphore(1);
    private Semaphore semaphoreOdd = new Semaphore(0);
    private Semaphore semaphoreEven = new Semaphore(0);
    private int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
    }


    public void odd(IntConsumer printNumber) throws InterruptedException {

        for (int i = 1; i < n; i++) {
            semaphore0.acquire();
            printNumber.accept(0);
            if (i % 2 == 1) {
                semaphoreOdd.release();
            } else {
                semaphoreEven.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            semaphoreEven.acquire();
            printNumber.accept(i);
            semaphore0.release();
        }
    }


}
