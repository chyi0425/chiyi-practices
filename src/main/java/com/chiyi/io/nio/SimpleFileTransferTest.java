package com.chiyi.io.nio;


import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Pipe;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author chiyi
 * @date 2019/2/21.
 */
public class SimpleFileTransferTest {
    private long transferFile(File source, File des) throws IOException {
        long startTime = System.currentTimeMillis();
        if (!des.exists()) {
            des.createNewFile();
        }

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(des));

        byte[] bytes = new byte[1024 * 1024];
        int len;
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private long transferFileWithNIO(File source, File des) throws IOException {
        long startTime = System.currentTimeMillis();

        if (!des.exists()) {
            des.createNewFile();
        }

        RandomAccessFile read = new RandomAccessFile(source, "rw");
        RandomAccessFile write = new RandomAccessFile(source, "rw");

        FileChannel readChannel = read.getChannel();
        FileChannel writeChannel = write.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024 * 1024);

        while (readChannel.read(byteBuffer) > 0) {
            byteBuffer.flip();
            writeChannel.write(byteBuffer);
            byteBuffer.clear();
        }

        writeChannel.close();
        readChannel.close();
        long endTime = System.currentTimeMillis();
        return endTime - startTime;

    }

    public static void main(String[] args) throws IOException {
        SimpleFileTransferTest simpleFileTransferTest = new SimpleFileTransferTest();
        File sourse = new File("F:\\电影\\[电影天堂www.dygod.cn]猜火车-cd1.rmvb");
        File des = new File("X:\\Users\\ozc\\Desktop\\io.avi");
        File nio = new File("X:\\Users\\ozc\\Desktop\\nio.avi");

        long time = simpleFileTransferTest.transferFile(sourse, des);
        System.out.println(time + "：普通字节流时间");

        long timeNio = simpleFileTransferTest.transferFileWithNIO(sourse, nio);
        System.out.println(timeNio + "：NIO时间");
    }

    // 使用直接缓冲区完成文件的复制(内存映射文件)
    public static void test2() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("2.jpg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE_NEW);

        // 内存映射文件
        MappedByteBuffer inMappedBuf = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMappedBuf = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

        // 直接对缓冲区进行数据的读写操作
        byte[] dst = new byte[inMappedBuf.limit()];
        inMappedBuf.get(dst);
        outMappedBuf.put(dst);
    }

    public static void scatterGatterTest() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("1.txt", "r");
        FileChannel channel1 = raf1.getChannel();

        ByteBuffer buf1 = ByteBuffer.allocate(100);
        ByteBuffer buf2 = ByteBuffer.allocate(1024);

        ByteBuffer[] bufs = {buf1, buf2};

        channel1.read(bufs);

        for (ByteBuffer buffer : bufs) {
            buffer.flip();
        }

        System.out.println(new String(bufs[0].array(), 0, bufs[0].limit()));
        System.out.println(new String(bufs[1].array(), 0, bufs[1].limit()));

        // 聚集写入
        RandomAccessFile raf2 = new RandomAccessFile("2.txt", "rw");
        FileChannel channel2 = raf2.getChannel();

        channel2.write(bufs);
    }

    public static void pipeTest() throws IOException {
        // 1. 获取管道
        Pipe pipe = Pipe.open();

        // 2. 将缓冲区的数据写入到管道
        ByteBuffer buf = ByteBuffer.allocate(1024);

        Pipe.SinkChannel sinkChannel = pipe.sink();

        buf.put("通过单向管道发送数据".getBytes());
        buf.flip();

        // 3. 读取缓冲区的数据
        Pipe.SourceChannel sourceChannel = pipe.source();
        buf.flip();
        int len = sourceChannel.read(buf);
        System.out.println(new String(buf.array(),0,len));

        sourceChannel.close();
        sinkChannel.close();
    }
}
