package com.chiyi.concurrency.contextswitch;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.*;

public class App {
    // init thread pool
    private static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(64, 64, 10,
            TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(1000), new ThreadPoolExecutor.DiscardOldestPolicy());

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        int cores = Runtime.getRuntime().availableProcessors();

        int requestNum = 100;
        System.out.println("CPU核数" + cores);

        List<Future<?>> futureList = new ArrayList<>();

        Vector<Long> wholeTimeList = new Vector<>();
        Vector<Long> runTimeList = new Vector<>();

        for (int i = 0; i < requestNum; i++) {
//            Future<?> future = threadPool.submit(new CpuTypeTest(wholeTimeList,runTimeList));


            Future<?> future = threadPool.submit(new IOTpyeTest(runTimeList,wholeTimeList));
            futureList.add(future);
        }

        for (Future<?> future : futureList) {
            future.get(requestNum, TimeUnit.SECONDS);
        }

        long wholeTime = 0;

        for (int i = 0; i < wholeTimeList.size(); i++) {
            wholeTime = wholeTimeList.get(i) + wholeTime;
        }

        long runTime = 0;
        for (int i = 0; i < runTimeList.size(); i++) {
            runTime = runTimeList.get(i) + runTime;
        }
        System.out.println("平均每个线程整体花费时间： " +wholeTime/wholeTimeList.size());
        System.out.println("平均每个线程执行花费时间： " +runTime/runTimeList.size());
    }
}
