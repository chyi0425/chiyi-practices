package com.chiyi.concurrency.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chiyi
 */
public class AtomicInc {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(10);
        long begin = System.nanoTime();
        for(int i=0;i<10;i++){
            new Thread(){
                @Override
                public void run() {
                    while(AtomicNumber.get()<100000000){
                        AtomicNumber.inc();
                    }
                    latch.countDown();
                }
            }.start();
        }
        try {
            latch.await();
            System.out.println("took "+(System.nanoTime()-begin)/1000000+" ms");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
class AtomicNumber {
    public static AtomicInteger value = new AtomicInteger(0);
    public  static void inc(){
        value.incrementAndGet();
    }
    public static int get(){
        return value.get();
    }
}