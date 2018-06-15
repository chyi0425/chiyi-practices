package com.chiyi.concurrency.threadpool;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 实现核心的几个点
 * 1. 线程池的核心线程数与最大线程数
 * 2. 线程池里真正工作的线程 Worker
 * 3. 线程池里用来存取任务的队列
 * 4. 线程中的任务 task
 */
public class MyThreadExecutor {
    private volatile boolean RUNNING = true;

    // put all task into queue,and the worker consume it
    private static BlockingQueue<Runnable> queue = null;

    private final HashSet<Worker> workers = new HashSet<>();

    private final List<Thread> threadList = new ArrayList<>();

    // the working thread num
    int poolSize = 0;

    // the num of core thread(the num of working thread)
    int coreSize = 0;

    boolean shutdown = false;

    public MyThreadExecutor(int poolSize) {
        this.poolSize = poolSize;
        queue = new LinkedBlockingQueue<>(poolSize);
    }

    public void exec(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException();
        }
        if (coreSize < poolSize) {
            addThread(runnable);
        } else {
            System.out.println("offer" + runnable.toString() + "    " + queue.size());
            try {
                queue.put(runnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void addThread(Runnable runnable) {
        coreSize++;
        Worker worker = new Worker(runnable);
        workers.add(worker);
        Thread t = new Thread(worker);
        threadList.add(t);
        try {
            t.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void shutdown() {
        RUNNING = false;
        if (!workers.isEmpty()) {
            for (Worker worker : workers) {
                worker.interruptIfIdle();
            }
        }
        shutdown = true;
        Thread.currentThread().interrupt();
    }

    class Worker implements Runnable {

        public Worker(Runnable runnable) {
            queue.offer(runnable);
        }

        @Override
        public void run() {
            while (true && RUNNING) {
                if (shutdown == true) {
                    Thread.interrupted();
                }
                Runnable task = null;
                try {
                    task = getTask();
                    task.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public Runnable getTask() throws InterruptedException {
            return queue.take();
        }

        public void interruptIfIdle() {
            for (Thread thread : threadList) {
                System.out.println(thread.getName() + " interrupt");
                thread.interrupt();
            }
        }
    }
}

