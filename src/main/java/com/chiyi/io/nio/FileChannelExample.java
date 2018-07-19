package com.chiyi.io.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Here are the most important Channel implementation in Java NIO:
 * FileChannel : reads data from and to files.
 * DatagramChannel : can read and write data over the network via UDP.
 * SocketChannel : can read and write data over the network via TCP.
 * ServerSocketChannel : allows you to listen for incoming TCP connections,like a web server does.For each in coming
 *                       connection a SocketChannel is created.
 *
 * Here is a basic example that uses a FileChannel to read some data into a Buffer.
 * Using a Buffer to read and write data typically follows this little 4-step process:
 * 1.Write data into a Buffer
 * 2.Call buffer.flip()
 * 3.Read data out of the Buffer
 * 4.Call buffer.clear() Or buffer.compat()
 *
 * A buffer is essentially a block of memory into which you can write data,which you can then later read again.This memory
 * block is wrapped in a NIO Buffer object,which provides a set of methods that makes it easier to work with the memory block.
 * A buffer has three properties you need to be familiar with,in order to understand how a Buffer works.These ara:capacity;position;limit
 *
 * The meaning of position and limit depends on whether the Buffer is in read or write mode.Capacity always means the same,no matter the buffer mode.
 *
 * Capacity: Being a memory block,a Buffer has a certain fixed size,also called its "capacity".You can only write capacity bytes,longs,chars etc. into
 *          Buffer.Once the Buffer is full,you need to empty it(read the data,or clear it)before you can write more data into it.
 * Position:When you write data into the Buffer, you do so at a certain position.Initially the position is 0.When a byte,long etc.has been written into the
 *          Buffer the position is advanced to point to the next cell in the buffer to insert data into.Position can maximally become capacity -1.
 *          When you read data from a Buffer you also do so from a given position.When you flip a Buffer from writing mode to reading mode,the position is
 *          reset back to 0.As you read data from the Buffer you do so from position,and position is advanced to next position to read.
 * Limit:   In write mode the limit of a Buffer is the limit of how much data you can write into the buffer.In write mode the limit is equal to the capacity
 *          of the Buffer.
 *          When flipping the Buffer into read mode,limit means the limit of how much data you can read from the data.Therefore,when flipping a Buffer into
 *          read mode,limit is set to write position of the write mode.In other words,you can read as many bytes as were written(limit is set to the number
 *          of bytes written,which is marked by position.)
 *
 * You can write data into a Buffer in two ways:1.Write data from a Channel into a Buffer. 2.Write data into the Buffer yourself,via the buffer's put() methods.
 * int bytesRead = inChannel.read(buf); //read into buffer
 * buf.put(127);
 *
 * The Buffer.rewind() sets the position back to 0,so you can reread all the data in the buffer.The limit remains untouched,thus still marking how many
 * elements(bytes,chars etc.) that can be read from the Buffer.
 *
 * If you call clear() the position is set back to 0 and the limit to capacity.In other words,the Buffer is cleared. The data in the Buffer is not cleared.
 * Only the markers telling where you can write data into the Buffer are.
 *
 * compact() copies all unread data to the beginning of the Buffer.Then it sets position to right after the last unread element.The limit property is still
 * set to capacity,just like clear() does.Now the Buffer is ready for writing,but you will not overwrite the unread data.
 */
public class FileChannelExample {
    public static void main(String[] args) throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("nio-data.txt","rw");
        FileChannel inChannel = aFile.getChannel();

        // create buffer with capacity of 48 bytes
        ByteBuffer buf = ByteBuffer.allocate(48);

        // read into buffer.
        int bytesRead = inChannel.read(buf);
        while (bytesRead!=-1){
            System.out.println("Read "+bytesRead);

            // make buffer ready for read(write model)
            buf.flip();

            while (buf.hasRemaining()){
                System.out.print((char)buf.get());
            }

            // make buffer ready for writing(read model)
            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }
}
