package com.chiyi.io.nio;

import java.nio.ByteBuffer;

/**
 * @author chiyi
 * @date 2019/2/22.
 */
public class NIOBufferTest {
    public static void main(String[] args) {
        // create buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // show the value of the variable
        System.out.println("初始时-->limit-->" + buffer.limit());
        System.out.println("初始时-->position-->" + buffer.position());
        System.out.println("初始时-->capacity-->" + buffer.capacity());
        System.out.println("初始时-->mark-->" + buffer.mark());

        System.out.println("----------------------------------------------");

        // put some data into buffer
        String s = "Java3y";
        buffer.put(s.getBytes());

        // show the value of the variable
        System.out.println("put之后-->limit-->" + buffer.limit());
        System.out.println("put之后-->position-->" + buffer.position());
        System.out.println("put之后-->capacity-->" + buffer.capacity());
        System.out.println("put之后-->mark-->" + buffer.mark());
        System.out.println("----------------------------------------------");

        buffer.flip();

        System.out.println("flip之后-->limit-->" + buffer.limit());
        System.out.println("flip之后-->position-->" + buffer.position());
        System.out.println("flip之后-->capacity-->" + buffer.capacity());
        System.out.println("flip之后-->mark-->" + buffer.mark());
        System.out.println("----------------------------------------------");

        // 创建一个limit()大小的字节数组(因为就只有limit这么多个数据可读)
        byte[] bytes = new byte[buffer.limit()];

        // 将读取的数据装进我们的字节数组中
        buffer.get(bytes);

        // 输出数据
        System.out.println(new String(bytes, 0, bytes.length));
        System.out.println("----------------------------------------------");
        System.out.println("get之后-->limit-->" + buffer.limit());
        System.out.println("get之后-->position-->" + buffer.position());
        System.out.println("get之后-->capacity-->" + buffer.capacity());
        System.out.println("get之后-->mark-->" + buffer.mark());

        buffer.clear();
        System.out.println("----------------------------------------------");
        System.out.println("clear之后-->limit-->" + buffer.limit());
        System.out.println("clear之后-->position-->" + buffer.position());
        System.out.println("clear之后-->capacity-->" + buffer.capacity());
        System.out.println("clear之后-->mark-->" + buffer.mark());
    }
}
