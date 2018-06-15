package com.chiyi.concurrency.threadpool;

public class ThreadBlockedQ {
    public static void main(String[] args) {
        MyThreadExecutor executor = new MyThreadExecutor(3);
        for(int i=0;i<10;i++){
            executor.exec(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程 "+Thread.currentThread().getName()+" 在帮我干活");
                }
            });
        }
        executor.shutdown();
    }
}
