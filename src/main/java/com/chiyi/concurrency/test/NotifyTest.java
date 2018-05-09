package com.chiyi.concurrency.test;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author chiyi
 */
public class NotifyTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main:start at"+new Date());
        Thread t1 = new Thread(new T1());
        t1.start();
        Thread t2 = new Thread(new T2());
        t2.start();
    }
}

class T1 implements Runnable{
    @Override
    public void run() {
        try {

            System.out.println("T1:start at"+new Date());
            TimeUnit.SECONDS.sleep(3);
            System.out.println("T1:end at"+new Date());
            synchronized (this){
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class T2 implements Runnable{

    @Override
    public void run() {
        try {
            synchronized (this){
                wait(10000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("T2:start at"+new Date());
    }
}
