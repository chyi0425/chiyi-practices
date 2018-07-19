package com.chiyi.io.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author chiyi
 * @date 2018/7/19.
 */
public class ReadAndShow {
    public static void main(String[] args) throws IOException {
        FileInputStream fin = new FileInputStream("readandshow.txt");
        FileChannel fc = fin.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1204);
        fc.read(buffer);
        buffer.flip();
        int i= 0;
        while (buffer.remaining()>0){
            byte b= buffer.get();
            System.out.println("Character "+i+": "+(char)b);
            i++;
        }
        fin.close();
    }
}
