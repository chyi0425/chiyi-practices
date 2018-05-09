package com.chiyi.concurrency.atomic;

import java.util.concurrent.CountDownLatch;

/**
 * @author chiyi
 */
public class SynInc {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(10);

        long begin = System.nanoTime();
        for(int i=0;i<10;i++){
            new Thread(){
                @Override
                public void run() {
                    while(Number.get()<100000000){
                        Number.inc();
                    }
                    latch.countDown();
                }
            }.start();
        }

        try {
            latch.await();
            System.out.println("took "+(System.nanoTime()-begin)/1000000 + " ms");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}

class Number{
    public static volatile int value=0;
    public static synchronized void inc(){
        value++;
    }

    public static int get(){
        return value;
    }
}
