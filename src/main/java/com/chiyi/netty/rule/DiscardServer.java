package com.chiyi.netty.rule;

/**
 * @author chiyi
 * @date 2018/7/23.
 */
public class DiscardServer {
    private int port;

    public DiscardServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) {
        int port;
        if(args.length>0){
            port = Integer.parseInt(args[0]);
        }else {
            port = 8080;
        }
        new DiscardServer(port).run();
        System.out.println("server:run()");
    }

    private void run() {
    }
}
