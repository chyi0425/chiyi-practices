package com.chiyi.concurrency.test;

/**
 * @author chiyi
 */
public class TestSync2 implements Runnable {

    int b = 100;

    synchronized void m1() throws InterruptedException {
//        System.out.println("m1-1:" + Thread.currentThread().getName()+"."+System.currentTimeMillis());
        b = 1000;
        Thread.sleep(500);
        System.out.println("b=" + b);
//        System.out.println("m1-2:" + Thread.currentThread().getName()+"."+System.currentTimeMillis());
    }

    synchronized void m2() throws InterruptedException {
        Thread.sleep(250);
        b = 2000;
//        System.out.println("m2:" + Thread.currentThread().getName()+"."+System.currentTimeMillis());
    }

    public static void main(String[] args) throws InterruptedException {
        TestSync2 tt = new TestSync2();
        Thread t = new Thread(tt);
        t.start();

        tt.m2();
        System.out.println("main thread b= " + tt.b);
    }

    @Override
    public void run() {
        try {
            m1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
