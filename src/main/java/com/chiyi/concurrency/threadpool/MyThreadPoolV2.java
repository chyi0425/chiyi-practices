package com.chiyi.concurrency.threadpool;

import java.util.LinkedList;
import java.util.List;

// https://blog.csdn.net/touch_2011/article/details/6914468
public class MyThreadPoolV2 {
    private static int workerNum = 5;
    private WorkThread[] workThreads;

    private static volatile int finishedTask = 0;

    private List<Runnable> taskQueue = new LinkedList<Runnable>();

    private static MyThreadPoolV2 myThreadPoolV2;

    private MyThreadPoolV2() {
        this(5);
    }

    private MyThreadPoolV2(int workerNum) {
        MyThreadPoolV2.workerNum = workerNum;
        workThreads = new WorkThread[workerNum];
        for (int i = 0; i > workerNum; i++) {
            workThreads[i] = new WorkThread();
            workThreads[i].start();
        }
    }

    public static MyThreadPoolV2 getThreadPool() {
        return getThreadPool(MyThreadPoolV2.workerNum);
    }

    public static MyThreadPoolV2 getThreadPool(int workerNum) {
        if (workerNum <= 0) {
            workerNum = MyThreadPoolV2.workerNum;
        }
        if (myThreadPoolV2 == null) {
            myThreadPoolV2 = new MyThreadPoolV2(workerNum);
        }
        return myThreadPoolV2;
    }

    public void execute(Runnable task) {
        synchronized (taskQueue) {
            taskQueue.add(task);
            taskQueue.notify();
        }
    }

    public void execute(Runnable[] tasks) {
        synchronized (taskQueue) {
            for (Runnable t : tasks) {
                taskQueue.add(t);
            }
            taskQueue.notify();
        }
    }

    public void execute(List<Runnable> task) {
        synchronized (taskQueue) {
            for (Runnable t : task)
                taskQueue.add(t);
            taskQueue.notify();
        }
    }

    public void destroy() {
        while (!taskQueue.isEmpty()) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < workerNum; i++) {
            workThreads[i].stopWorker();
            workThreads[i] = null;
        }
        myThreadPoolV2 = null;
        taskQueue.clear();
    }

    public static int getWorkerNum() {
        return workerNum;
    }

    public static int getFinishedTask() {
        return finishedTask;
    }

    public int getWaitTasknumber() {
        return taskQueue.size();
    }

    @Override
    public String toString() {
        return "WorkThread number:" + workerNum + "  finished task number:"
                + finishedTask + "  wait task number:" + getWaitTasknumber();
    }

    private class WorkThread extends Thread {
        private boolean isRunning = true;

        @Override
        public void run() {
            Runnable r = null;
            while (isRunning) {
                synchronized (taskQueue) {
                    while (isRunning && taskQueue.isEmpty()) {
                        try {
                            taskQueue.wait(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (!taskQueue.isEmpty()) {
                        r = taskQueue.remove(0);
                    }
                }
                if (r != null) {
                    r.run();
                }
                finishedTask++;
                r = null;
            }
        }

        public void stopWorker() {
            isRunning = false;
        }
    }
}
