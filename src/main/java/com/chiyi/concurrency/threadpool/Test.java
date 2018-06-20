package com.chiyi.concurrency.threadpool;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    private ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<String>();
    private CountDownLatch latch = new CountDownLatch(10000);
    ExecutorService es = Executors.newFixedThreadPool(4);
    public static void main(String[] args) {
        Test test001 = new Test();
        long timeStart = System.currentTimeMillis();
        test001.start();
        System.out.println(System.currentTimeMillis()-timeStart);
    }

    public void start(){
        for (int i = 0; i < 10000; i++) {
            RunnableTest runnableTest = this.new RunnableTest(i);
            es.submit(runnableTest);
//          new Thread(runnableTest).start();
        }
        es.shutdown();
        try {
            //等待latch计数为0
            latch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(queue.size());
    }

    private class RunnableTest implements Runnable{
        private int value;
        public RunnableTest(int value) {
            this.value = value;
        }
        @Override
        public void run() {
            try {
//              barrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            queue.offer(value+"");
            latch.countDown();//latch计数减一
        }

    }

}
