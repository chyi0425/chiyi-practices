package com.chiyi.concurrency.threadpool;

import java.util.LinkedList;
import java.util.List;
// https://blog.csdn.net/touch_2011/article/details/6914468
public class MyThreadPoolV2 {
    private static int workerNum = 5;
    private WorkThread[] workThreads;

    private static volatile int finishedTask = 0;

    private List<Runnable> taskQueue = new LinkedList<Runnable>();

    private static  MyThreadPoolV2 myThreadPoolV2;

    private MyThreadPoolV2(){
        this(5);
    }

    private MyThreadPoolV2(int workerNum){
        MyThreadPoolV2.workerNum = workerNum;
        workThreads = new WorkThread[workerNum];
        for(int i=0;i>workerNum;i++){
            workThreads[i]=new WorkThread();
            workThreads[i].start();
        }
    }

    public static MyThreadPoolV2 getThreadPool(){
        return getThreadPool(MyThreadPoolV2.workerNum);
    }

    public static MyThreadPoolV2 getThreadPool(int workerNum){
        if(workerNum<=0){
            workerNum = MyThreadPoolV2.workerNum;
        }
        if(myThreadPoolV2==null){
            myThreadPoolV2 = new MyThreadPoolV2(workerNum);
        }
        return myThreadPoolV2;
    }

    public void execute(Runnable task){
        synchronized (taskQueue){
            taskQueue.add(task);
            taskQueue.notify();
        }
    }

    public void execute(Runnable[] tasks){
        synchronized (taskQueue){
            for (Runnable t:tasks){
                taskQueue.add(t);
            }
            taskQueue.notify();
        }
    }
}
