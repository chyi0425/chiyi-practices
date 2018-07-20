package com.chiyi.io.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * @author chiyi
 * @date 2018/7/20.
 */
public class NIOChannelTransfers {
    public static void main(String[] args) {

    }

    public static void transferFrom() throws IOException {
        RandomAccessFile fromFile = new RandomAccessFile("fromFile.txt","rw");
        FileChannel fromChannel = fromFile.getChannel();

        RandomAccessFile toFile = new RandomAccessFile("toFile.txt","rw");
        FileChannel toChannel = toFile.getChannel();

        long position = 0;
        long count = fromChannel.size();
        // transfers data from a source channel into the FileChannel
        toChannel.transferFrom(fromChannel,position,count);
    }

    public static void transferTo()throws IOException{
        RandomAccessFile fromFile = new RandomAccessFile("fromFile.txt","rw");
        FileChannel fromChannel = fromFile.getChannel();

        RandomAccessFile toFile = new RandomAccessFile("toFile.txt","rw");
        FileChannel toChannel = toFile.getChannel();

        long position = 0;
        long count = fromChannel.size();
        // transfer from a FileChannel
        fromChannel.transferTo(position,count,toChannel);
    }
}
