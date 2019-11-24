package com.chiyi.concurrency.contextswitch;

public class TestApplication {

    public static void main(String[] args) {
        MultiThreadTester test1 = new MultiThreadTester();
        test1.start();

        SerialTester test2 = new SerialTester();
        test2.start();
    }


    static abstract class ThreadContextSwitchTester {
        public static final int count = 100000000;
        public volatile int counter = 0;

        public int geyCount() {
            return this.counter;
        }

        public void increaseCounter() {
            this.counter += 1;
        }

        public abstract void start();
    }

    static class SerialTester extends ThreadContextSwitchTester {

        @Override
        public void start() {
            long start = System.currentTimeMillis();
            for (int i = 0; i < count; i++) {
                increaseCounter();
            }
            long end = System.currentTimeMillis();
            System.out.println("serial exec time: " + (end - start) + "ms");
            System.out.println("counter:" + counter);
        }
    }

    static class MultiThreadTester extends ThreadContextSwitchTester{

        @Override
        public void start() {
            long start = System.currentTimeMillis();
            MyRunnable myRunnable = new MyRunnable();
            Thread[] threads = new Thread[4];
            for (int i=0;i<4;i++){
                threads[i] = new Thread(myRunnable);
                threads[i].start();
            }
            for (int i=0;i<4;i++){
                try {
                    threads[i].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            long end = System.currentTimeMillis();
            System.out.println("multi thread exec time: " + (end - start) + "ms");
            System.out.println("counter:" + counter);

        }

        class MyRunnable implements Runnable{

            @Override
            public void run() {
                while (counter<100000000){
                    synchronized (this){
                        if (counter<100000000){
                            increaseCounter();
                        }
                    }
                }
            }
        }
    }
}
