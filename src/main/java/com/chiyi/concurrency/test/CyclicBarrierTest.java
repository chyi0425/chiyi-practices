package com.chiyi.concurrency.test;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chiyi
 */
public class CyclicBarrierTest {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(8);
    private static ExecutorService service = Executors.newFixedThreadPool(50);

    public static void main(String[] args) {
        for(int i=0;i<9;i++){
            service.execute(new Thread(new Runner(i,cyclicBarrier)));
        }
        service.shutdown();
    }
}
