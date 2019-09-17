package com.chiyi.verticalscaling;

import java.io.IOException;

/**
 * @author chiyi
 * @date 2019/8/1.
 */
public class Test {
    public static void main(String[] args) throws InterruptedException, IOException {
        int sleep = 10;
        if (args.length > 0){
            sleep = Integer.parseInt(args[0]);
        }
        new Thread(new MemoryUsage()).start();
        while (true) {
            System.in.read();
            Load test = new Load(sleep);
            test.run();
//            test = null;

            Thread.sleep(10000);
            //System.gc();
        }
    }

}
