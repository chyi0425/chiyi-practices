package com.chiyi.concurrency.test;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        // ...
    }

    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
