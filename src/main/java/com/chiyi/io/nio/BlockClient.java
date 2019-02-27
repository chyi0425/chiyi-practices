package com.chiyi.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author chiyi
 * @date 2019/2/27.
 */
public class BlockClient {
    public static void main(String[] args) throws IOException {
        // 获取通道

        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",6666));

        // 发送一张图片给服务端
        FileChannel fileChannel = FileChannel.open(Paths.get("G:\\chyi0425.github.io\\source\\img\\about-nio-30.png"), StandardOpenOption.READ);

        // 要使用NIO，有了Channel，就必然要有Buffer，Buffer是与数据打交道的
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // 读取本地文件，发送到服务器
        while (fileChannel.read(buffer)!=-1){
            // 在读之前都要切换成读模式
            buffer.flip();

            socketChannel.write(buffer);

            // 读完切换成写模式，能让管道继续读取文件的数据
            buffer.clear();
        }

        // 告诉服务端已经写完了
        socketChannel.shutdownOutput();

        // 知道服务端要返回响应的数据给客户端，客户端在这里接收
        int len = 0;
        while ((len = socketChannel.read(buffer))!=-1){
            // 切换读模式
            buffer.flip();
            System.out.println(new String(buffer.array(),0,len));
            // 切换写模式
            buffer.clear();
        }
        // 关闭流
        fileChannel.close();
        socketChannel.close();
    }
}
