package com.chiyi.concurrency.shutdownAndCancel;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author chiyi
 */
public class BrokenPrimeProducer extends Thread {
    private final BlockingQueue<BigInteger> queue;
//    private volatile boolean cancelled = false;
    BrokenPrimeProducer(BlockingQueue<BigInteger> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            BigInteger p = BigInteger.ONE;

//            while (!cancelled){
//                queue.put(p.nextProbablePrime());
//            }
            while (Thread.currentThread().isInterrupted()){
                queue.put(p.nextProbablePrime());
            }

            System.out.println("done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void cancel() {
//        cancelled = true;
        interrupt();
    }

    private static final ScheduledExecutorService cancelExec = Executors.newScheduledThreadPool(2);
    //
//    public static void timeRun(Runnable r, long timeout, TimeUnit unit){
//        final Thread taskThread = Thread.currentThread();
//        cancelExec.schedule(new Runnable() {
//            @Override
//            public void run() {
//                taskThread.interrupt();
//            }
//        },timeout,unit);
//        r.run();;
//    }

    public static void timeRun(Runnable r, long timeout, TimeUnit unit) throws InterruptedException {
        class RethrowableTask implements Runnable{
        private volatile Throwable t;
            @Override
            public void run() {
                try{
                    r.run();
                }catch (Throwable t){
                    this.t = t;
                }
            }

            void rethrow(){
                if(t!=null){
//                    throw launderThrowable(t);
                }
            }
        }

        RethrowableTask task = new RethrowableTask();
        final Thread taskThread = new Thread(task);
        taskThread.start();
        cancelExec.schedule(new Runnable() {
            @Override
            public void run() {
                taskThread.interrupt();
            }
        },timeout,unit);
        taskThread.join(unit.toMillis(timeout));
    }
}
