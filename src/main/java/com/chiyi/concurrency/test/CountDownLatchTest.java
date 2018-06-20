package com.chiyi.concurrency.test;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author chiyi
 */
public class CountDownLatchTest {
    private static CountDownLatch countDownLatch = new CountDownLatch(4);
    private static ExecutorService service = Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws InterruptedException {
        for (int i=0;i<4;i++){
            service.execute(new Runnable() {
                public void run() {
                    try{
                        int timer = new Random().nextInt(5);
                        TimeUnit.SECONDS.sleep(timer);
                        System.out.printf("%s时完成磁盘的统计任务，耗时%d秒.\n",new Date().toString(),timer);
                        // 任务完成后，计数器减一
                        countDownLatch.countDown();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            });
        }
        countDownLatch.await();
        System.out.printf("%s时全部任务都完成，执行时合并计算。\n",new Date().toString());
        service.shutdown();
    }
}
