package com.chiyi.concurrency.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CachedThreadPool：一个任务创建一个线程；
 * FixedThreadPool：所有任务只能使用固定大小的线程；
 * SingleThreadExecutor：相当于大小为 1 的 FixedThreadPool。
 */
public class SynchronizedExample {
    public void func1(){
//        synchronized (this){
        synchronized (SynchronizedExample.class){
            for(int i=0;i<10;i++){
                System.out.println(i+" ");
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedExample e1 = new SynchronizedExample();
        SynchronizedExample e2 = new SynchronizedExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->e1.func1());
//        executorService.execute(()->e1.func1());
        executorService.execute(()->e2.func1());
    }
}
