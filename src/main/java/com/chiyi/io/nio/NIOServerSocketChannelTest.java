package com.chiyi.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.text.MessageFormat;

/**
 * @author chiyi
 * @date 2018/7/20.
 */

public class NIOServerSocketChannelTest {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        // set is blocking
        serverChannel.configureBlocking(true);
        serverChannel.bind(new InetSocketAddress(7794));

        int count = 0;
        while (true) {
            try {
                SocketChannel channel = serverChannel.accept();
                System.out.println(MessageFormat.format("Connection [{0}] build up.", count++));
                ByteBuffer buffer = ByteBuffer.allocate(16);
                System.out.println(">>>");

                while (channel.read(buffer) != -1) {
                    buffer.flip();
                    while (buffer.hasRemaining()){
                        System.out.print((char)buffer.get());
                    }
                    buffer.clear();
                }
                channel.shutdownInput();
                System.out.println();
                System.out.println("Finished read from Client.");

                // response to client
                channel.write(ByteBuffer.wrap("Hello World Response".getBytes()));
                channel.shutdownOutput();
                channel.close();
                System.out.println("Finished write response to Client");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
