package com.chiyi.concurrency.test;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author chiyi
 */
public class SemaphoreTest {
    private static Semaphore semaphore = new Semaphore(3);
    private static ExecutorService service = Executors.newFixedThreadPool(6);

    public static void main(String[] args) {
        for(int i=0;i<9;i++){
            final int finalI = i;
            service.execute(new Runnable() {
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.printf("%d号任务,%s时获取资源，并调用。\n", finalI,new Date().toString());
                        //线程挂起3秒
                        TimeUnit.SECONDS.sleep(3);
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        service.shutdown();
    }
}
