package com.chiyi.verticalscaling;

import java.util.LinkedList;
import java.util.List;

/**
 * @author chiyi
 * @date 2019/8/1.
 */
public class Load {
    private int sleep = 0;

    public Load(int sleep) {
        this.sleep = sleep;
    }

    public void run() throws InterruptedException {
        long start = System.currentTimeMillis();
        try {
            int n = 1*1024*512/2;
            List list = new LinkedList();
            for (int i=0;i<n;i++){
                String[] str = new String[1024];
                list.add(str);
                if(i%100==0){
                    System.out.println("i= "+i);
                    Thread.sleep(sleep);
                }
            }
        }catch (OutOfMemoryError e){
            e.printStackTrace();
        }
        System.out.println("total time = " + (System.currentTimeMillis() - start) + ", ms");
        System.out.println("done");
    }
}
