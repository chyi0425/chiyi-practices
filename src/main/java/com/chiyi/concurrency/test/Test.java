package com.chiyi.concurrency.test;

/**
 * @author chiyi
 * @date 2018/6/14.
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread("");
        a.start();
        synchronized(a){
            a.wait();
        }
    }

}
