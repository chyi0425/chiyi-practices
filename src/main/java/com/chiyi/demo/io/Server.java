package com.chiyi.demo.io;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static int DEFAULT_PORT = 12345;
    private static ServerSocket server;

    private static ExecutorService executorService = Executors.newFixedThreadPool(60);

    public static void start() throws IOException {
        start(DEFAULT_PORT);
    }

    private synchronized static void start(int port) throws IOException {
        if (server != null) {
            return;
        }
        try {
            server = new ServerSocket(port);
            System.out.println("服务器已启动，端口号："+port);

            while (true){
                Socket socket = server.accept();
                executorService.execute(new ServerHandler(socket));
            }
        }finally {
            if(server!=null){
                System.out.println("服务器已关闭。");
                server.close();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Server.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
