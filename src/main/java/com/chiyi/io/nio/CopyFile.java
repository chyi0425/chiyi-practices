package com.chiyi.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author chiyi
 * @date 2018/7/19.
 */
public class CopyFile {
    public static void main(String[] args) throws IOException {
        if(args.length<2){
            System.err.println( "Usage: java CopyFile infile outfile" );
            System.exit( 1 );
        }
        String infile = args[0];
        String outfile = args[1];

        FileInputStream fin = new FileInputStream( infile );
        FileOutputStream fout = new FileOutputStream( outfile );

        FileChannel fcin = fin.getChannel();
        FileChannel fcout = fout.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // clear() 方法重设缓冲区，使它可以接受读入的数据。
        // flip() 方法让缓冲区可以将新读入的数据写入另一个通道。
        while (true){
            buffer.clear();

            int r=fcin.read(buffer);
            if (r==-1){
                break;
            }

            buffer.flip();

            fcout.write(buffer);
        }

        fcin.close();
        fcout.close();
        fin.close();
        fout.close();

    }
}
