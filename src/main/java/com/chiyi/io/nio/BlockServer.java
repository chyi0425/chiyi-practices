package com.chiyi.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author chiyi
 * @date 2019/2/27.
 */
public class BlockServer {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel server = ServerSocketChannel.open();

        // 得到文件通道，将客户端传递过来的图片写到本地项目下(写模式，没有则创建)
        FileChannel outChannel = FileChannel.open(Paths.get("2.png"), StandardOpenOption.WRITE,StandardOpenOption.CREATE);

        // 绑定链接
        server.bind(new InetSocketAddress(6666));

        // 获取客户端的连接(阻塞的)
        SocketChannel client = server.accept();

        // 要使用NIO，有了Channel,就必然要有Buffer，Buffer是与数据打交道的
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // 将客户端传递过来的图片保存在本地中
        while (client.read(buffer)!=-1){
            // 在读之前都要切换为读模式
            buffer.flip();
            outChannel.write(buffer);

            // 切换为写模式
            buffer.clear();
        }
        // 通知客户端已经收到图片
        buffer.put("img is success".getBytes());
        buffer.flip();
        client.write(buffer);
        buffer.clear();

        // 关闭通道
        outChannel.close();
        client.close();
        server.close();
    }
}
