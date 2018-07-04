package com.chiyi.concurrency.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBuffer {
    final Lock lock = new ReentrantLock();

    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    final Object[] items = new Object[100];
    int putptr, takeptr, count;

    public void put(Object x) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length) {
                notFull.await(); // 队列已满，等待，知道not full才能继续生产
            }
            items[putptr] = x;
            if(++putptr == items.length){
                putptr=0;
            }
            ++count;
            notEmpty.signal();  // 生产成功，队列已经not empty了，发个通知出去
        }finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while (count==0){
                notEmpty.await();   // 队列为空，等待，知道队列not empty,才能继续消费
            }
            Object x= items[takeptr];
            if(++takeptr == items.length){
                takeptr=0;
            }
            --count;
            notFull.signal();   // 被我消费掉一个，队列not full，发个通知出去
            return x;
        }finally {
            lock.unlock();
        }
    }
}
