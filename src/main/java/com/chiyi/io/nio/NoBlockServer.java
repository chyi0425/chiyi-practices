package com.chiyi.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;

/**
 * @author chiyi
 * @date 2019/2/27.
 */
public class NoBlockServer {
    public static void main(String[] args) throws IOException {

        // 1. 获取通道
        ServerSocketChannel server = ServerSocketChannel.open();

        // 2. 配置非阻塞
        server.configureBlocking(false);

        // 3. 绑定链接
        server.bind(new InetSocketAddress(6666));

        // 4. 获取选择器
        Selector selector = Selector.open();

        // 4.1 将通道注册到选择器上，制定接收“监听通道”事件
        server.register(selector, SelectionKey.OP_ACCEPT);

        // 5. 轮询获取选择器上已“就绪”的事件--->只要select()>0，说明已就绪
        while (selector.select() > 0) {
            // 6. 获取当前选择器上所有注册的“选择键”(已经就绪的监听事件)
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            // 7. 获取“就绪”的事件(不同的事件做不同的事)
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                // 接收事件就绪
                if (selectionKey.isAcceptable()) {
                    // 8. 获取客户端的连接
                    SocketChannel client = server.accept();

                    //8.1 切换成非阻塞状态
                    client.configureBlocking(false);

                    // 8.2 注册到选择器上 ---> 拿到客户端的连接为了读取通道的数据(监听读就绪事件)
                    client.register(selector, SelectionKey.OP_READ);
                } else if (selectionKey.isReadable()) {
                    // 9. 获取当前选择器读就绪状态的通道
                    SocketChannel client = (SocketChannel) selectionKey.channel();

                    // 9.1 读取数据
                    ByteBuffer buffer = ByteBuffer.allocate(1024);

                    // 9.2 得到文件通道，将客户端传递过来的图片写到本地项目下
                    FileChannel outChannel = FileChannel.open(Paths.get("2.png"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);

                    while (client.read(buffer)>0){
                        // 在读之前切换成读模式
                        buffer.flip();

                        outChannel.write(buffer);

                        buffer.clear();
                    }
                    // 保存了图片之后，想要告诉客户端，图片已经上传了
                    ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
                    writeBuffer.put("the img is received,thanks you client.".getBytes());
                    writeBuffer.flip();
                    client.write(writeBuffer);
                }
                // 10 取消选择键(已经处理过的事件，就应该取消掉)
                iterator.remove();
            }



        }

    }
}
