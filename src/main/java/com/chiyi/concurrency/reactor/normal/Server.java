package com.chiyi.concurrency.reactor.normal;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{
    private static final int PORT = 8080;

    @Override
    public void run() {
        try {
            // create server socket
            ServerSocket ss = new ServerSocket(PORT);
            // create thread to handle request
            while (!Thread.interrupted()){
                new Thread(new Handler(ss.accept())).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Handler implements Runnable{
        private static final int MAX_INPUT = 111;
        final Socket socket;
        Handler(Socket s){
            socket = s;
        }
        @Override
        public void run() {
            try {
                byte[] input = new byte[MAX_INPUT];
                socket.getInputStream().read(input);
                byte[] output = process(input);
                socket.getOutputStream().write(output);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private byte[] process(byte[] cmd){
            return null;
        }
    }
}
