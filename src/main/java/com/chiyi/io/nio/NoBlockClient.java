package com.chiyi.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;

/**
 * @author chiyi
 * @date 2019/2/27.
 */
public class NoBlockClient {
    public static void main(String[] args) throws IOException {

        // 1. 获取通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 6666));

        // 1.1 切换为非阻塞模式
        socketChannel.configureBlocking(false);

        // 1.2 获取选择器
        Selector selector = Selector.open();

        // 1.3 将通道注册到选择器中，获取服务端返回的数据
        socketChannel.register(selector, SelectionKey.OP_READ);

        // 2. 发送一张图片给服务端
        FileChannel fileChannel = FileChannel.open(Paths.get("G:\\chyi0425.github.io\\source\\img\\about-nio-29.png"), StandardOpenOption.READ);

        // 3. Buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // 4. 读取本地文件，发送到服务端
        while (fileChannel.read(buffer) != -1) {
            // 在读之前要切换为读模式
            buffer.flip();

            socketChannel.write(buffer);

            // 读完切换成写模式，能让管道继续读取文件的数据
            buffer.clear();
        }

        // 轮询地获取选择器上已“就绪”的事件---> 只要select()>0，说明已就绪
        while (selector.select() > 0) {
            // 获取当前选择器所有注册的“选择键”(已就绪的监听事件)
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

            // 获取已经就绪的事件
            while (iterator.hasNext()){
                SelectionKey selectionKey = iterator.next();

                // 读事件就绪
                if(selectionKey.isReadable()){
                    // 得到对应的通道
                    SocketChannel channel = (SocketChannel) selectionKey.channel();

                    ByteBuffer responseBuffer = ByteBuffer.allocate(1024);

                    // 知道服务端要返回响应的数据给客户端，客户端在这里接收
                    int readBytes = channel.read(responseBuffer);
                    if(readBytes>0){
                        // 切换读模式
                        responseBuffer.flip();
                        System.out.println(new String(responseBuffer.array(),0,readBytes));
                    }
                }
                iterator.remove();
            }
        }
        // 5 关闭流
        fileChannel.close();
        socketChannel.close();
    }
}
