package com.chiyi.verticalscaling;

import java.lang.management.ManagementFactory;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author chiyi
 * @date 2019/8/1.
 */
public class MemoryUsage implements Runnable {
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Logger.getLogger(MemoryUsage.class.getName()).log(Level.SEVERE, null, e);
            }
            java.lang.management.MemoryUsage mu = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();
            Date dNow = new Date();
            SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");

            print(ft.format(dNow)+" -> Init",mu.getInit());
            print("Used",mu.getUsed());
            print("committed",mu.getCommitted());
            print("max",mu.getMax());

            System.out.println();
        }
    }

    private void print(String name, double value) {
        System.out.print(name + ": " + Math.round(value / 1024 / 1024) + "M ");
    }
}
