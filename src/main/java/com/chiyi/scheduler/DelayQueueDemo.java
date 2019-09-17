package com.chiyi.scheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author chiyi
 * @date 2019/5/28.
 */
public class DelayQueueDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("0000001");
        list.add("0000002");
        list.add("0000003");
        list.add("0000004");
        list.add("0000005");
        DelayQueue<OrderDelay> queue = new DelayQueue<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            queue.put(new OrderDelay(list.get(i), TimeUnit.NANOSECONDS.convert(3, TimeUnit.SECONDS)));
            try {
                System.out.println(queue.take());
                System.out.println("After " + (System.currentTimeMillis() - start) + " MilliSeconds");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
