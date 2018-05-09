package com.chiyi.concurrency.shutdownAndCancel;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

/**
 * @author chiyi
 */
public abstract class SocketUsingTask<T> implements CancellableTask<T> {
    private Socket socket;

    protected synchronized void setSocket(Socket socket){
        this.socket = socket;
    }

    @Override
    public synchronized void cancel() {
        try{
            if(socket!=null){
                socket.close();
            }
        }catch (IOException e){

        }
    }

    @Override
    public RunnableFuture<T> newTask() {
        return new FutureTask<T>(this){
            @Override
            public boolean cancel(boolean mayInterruptIfRunning) {
                try {
                    SocketUsingTask.this.cancel();
                }finally {
                    return super.cancel(mayInterruptIfRunning);
                }
            }
        };
    }
}
