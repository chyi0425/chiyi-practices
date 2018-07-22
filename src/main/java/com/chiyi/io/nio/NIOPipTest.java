package com.chiyi.io.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.util.Scanner;

public class NIOPipTest implements Runnable{
    private Pipe pipe;

    public NIOPipTest(Pipe pipe) {
        this.pipe = pipe;
    }


    @Override
    public void run() {
        try {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (pipe.source().read(buffer)>=0){
                buffer.flip();
                byte[] bytes = new byte[buffer.limit()];
                for(int i=0;buffer.hasRemaining();i++){
                    bytes[i] = buffer.get();
                }
                buffer.clear();
                System.out.println("Input: "+new String(bytes));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Pipe pipe = Pipe.open();
        new Thread(new NIOPipTest(pipe)).start();
        Scanner scanner = new Scanner(System.in);
        try {
            while (true){
                String input = scanner.next();
                pipe.sink().write(ByteBuffer.wrap(input.getBytes()));
            }
        }finally {
            scanner.close();
        }
    }
}
