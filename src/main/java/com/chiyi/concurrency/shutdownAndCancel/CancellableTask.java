package com.chiyi.concurrency.shutdownAndCancel;

import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

/**
 * @author chiyi
 */
public interface CancellableTask<T> extends Callable<T> {
    void cancel();
    RunnableFuture<T> newTask();
}
