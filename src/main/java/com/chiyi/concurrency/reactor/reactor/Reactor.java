package com.chiyi.concurrency.reactor.reactor;

import jdk.nashorn.internal.ir.LexicalContextNode;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 定义reactor，其中包括Selector和ServerSocketChannel
 * 将ServerSocketChannel和事件类型绑定到Seletor上，设置  serverSocket为非阻塞
 */
public class Reactor implements Runnable {
    final Selector selector;
    final ServerSocketChannel serverSocket;

    Reactor(int port) throws IOException {
        selector = Selector.open();
        serverSocket = ServerSocketChannel.open();
        serverSocket.socket().bind(new InetSocketAddress(port));
        serverSocket.configureBlocking(false);
        SelectionKey sk = serverSocket.register(selector, SelectionKey.OP_ACCEPT);
        sk.attach(new LexicalContextNode.Acceptor());
    }
    /*
     * Alternatively, use explicit SPI provider: SelectorProvider p =
     * SelectorProvider.provider(); selector = p.openSelector();
     * serverSocket = p.openServerSocketChannel();
     */



    //无限循环等待网络请求的到来
    //其中selector.select();会阻塞直到有绑定到selector的请求类型对应的请求到来，一旦收到事件，处理分发到对应的handler，并将这个事件移除
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                selector.select();
                Set<SelectionKey> selectionKeys =  selector.selectedKeys();
                Iterator<SelectionKey> it = selectionKeys.iterator();
                while (it.hasNext()){
                    dispatch(it.next());
                    selectionKeys.clear();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void dispatch(SelectionKey key) {
        Runnable r = (Runnable) (key.attachment());
        if(r!=null){
            r.run();
        }
    }

    class Acceptor implements Runnable{

        @Override
        public void run() {
            try {
                SocketChannel c = serverSocket.accept();
                if (c!=null){
                    new Handler(selector,c);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    final class Handler implements Runnable {
        private static final int MAX_IN = 100;
        private static final int MAX_OUT = 100;
        final SocketChannel socket;
        final SelectionKey sk;
        ByteBuffer input = ByteBuffer.allocate(MAX_IN);
        ByteBuffer output = ByteBuffer.allocate(MAX_OUT);
        static final int READING = 0, SENDING = 1;
        int state = READING;

        Handler(Selector sel, SocketChannel c) throws IOException {
            socket = c;
            c.configureBlocking(false);
            // Optionally try first read now
            sk = socket.register(sel, 0);
            sk.attach(this);
            sk.interestOps(SelectionKey.OP_READ);
            sel.wakeup();
        }

        boolean inputIsComplete() {
            return false;
        }

        boolean outputIsComplete() {
            return false;
        }

        boolean process() {
            return false;
        }

        //具体的请求处理，可能是读事件、写事件等
        @Override
        public void run() {
            try {
                if (state == READING) {
                    read();
                } else if (state == SENDING) {
                    send();
                }
            } catch (IOException e) {
                /* ...... */
            }
        }

        void read() throws IOException {
            socket.read(input);
            if (inputIsComplete()) {
                process();
                state = SENDING;
                // Normally also do first write now
                sk.interestOps(SelectionKey.OP_WRITE);
            }
        }

        void send() throws IOException {
            /* ... */
            socket.write(output);
            if (outputIsComplete()) {
                sk.cancel();
            }
        }
    }
}
