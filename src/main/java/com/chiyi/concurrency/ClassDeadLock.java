package com.chiyi.concurrency;

/**
 * @author chiyi
 * @date 2019/6/24.
 */
public class ClassDeadLock {
    public static final String res1 = "res1";
    public static final String res2 = "res2";

    public static void main(String[] args) throws InterruptedException {
        Thread lock1 = new Thread(new Lock1());
        Thread lock2 = new Thread(new Lock2());
        lock1.start();
        lock2.start();
        while (true){
            Thread.sleep(1000);
            System.out.println("******");
        }
    }

    static class Lock1 implements Runnable{

        @Override
        public void run() {
            synchronized (ClassDeadLock.res1){
                System.out.println("thread-1 locked res1");
                try{
                    Thread.sleep(300);
                    synchronized (ClassDeadLock.res2){
                        System.out.println("thread-1 locked res2");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Lock2 implements Runnable{

        @Override
        public void run() {
            synchronized (ClassDeadLock.res2){
                System.out.println("thread-2 locked res2");
                try {
                    Thread.sleep(300);
                    synchronized (ClassDeadLock.res1){
                        System.out.println("thread-2 locked res1");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
