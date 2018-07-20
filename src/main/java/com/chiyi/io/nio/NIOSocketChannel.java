package com.chiyi.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author chiyi
 * @date 2018/7/20.
 */
public class NIOSocketChannel {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        // 设置是否为阻塞式Socket IO，如果非阻塞，则connet(),read(),write()方法都将为异步
        // 本示例为阻塞模式，非阻塞模式将在Selector一章介绍
        socketChannel.configureBlocking(true);
        socketChannel.connect(new InetSocketAddress("127.0.0.1",7794));
        System.out.println("Connection building up.");
        while (!socketChannel.finishConnect()){
            System.out.println(".");
        }
        System.out.println();

        // send socket request
        socketChannel.write(ByteBuffer.wrap("Hello World".getBytes()));
        socketChannel.shutdownOutput();
        System.out.println("Client Request sended.");

        ByteBuffer response = ByteBuffer.allocate(16);
        System.out.println(">>>");

        while (socketChannel.read(response)!=-1){
            response.flip();
            while (response.hasRemaining()){
                System.out.print((char)response.get());
            }
            response.clear();
        }
        socketChannel.shutdownInput();
        System.out.println("\r\nFinished read from server.");
        socketChannel.close();
    }
}
