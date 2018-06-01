package com.chiyi.concurrency.threadlocal;

import java.util.concurrent.ConcurrentHashMap;

public class MyThreadLocal<T> {
    private ConcurrentHashMap<Thread,T> map = new ConcurrentHashMap<>();

    private static MyThreadLocal one;

    public static MyThreadLocal getInstanct(){
        if(one ==null){
            synchronized (MyThreadLocal.class){
                if(one==null){
                    one = new MyThreadLocal();
                }
            }
        }
        return one;
    }

    public void put(T obj){
        Thread current = Thread.currentThread();
        map.put(current,obj);
    }

    public T get(){
        return map.get(Thread.currentThread());
    }
}
