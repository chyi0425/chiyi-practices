package com.chiyi.scheduler;

import org.springframework.core.annotation.Order;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author chiyi
 * @date 2019/5/28.
 */
public class OrderDelay implements Delayed {
    private String orderId;
    private long timeout;

    public OrderDelay(String orderId, long timeout) {
        this.orderId = orderId;
        this.timeout = timeout + System.nanoTime();
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(timeout - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        if (o == this) {
            return 0;
        }
        OrderDelay t = (OrderDelay) o;
        long d = (getDelay(TimeUnit.NANOSECONDS) - t.getDelay(TimeUnit.NANOSECONDS));
        return (d == 0) ? 0 : ((d < 0) ? -1 : 1);
    }

    @Override
    public String toString() {
        return orderId + "编号的订单要删除了。。。";
    }
}
