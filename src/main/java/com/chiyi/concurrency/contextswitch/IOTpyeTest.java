package com.chiyi.concurrency.contextswitch;

import java.io.*;
import java.util.Vector;

public class IOTpyeTest implements Runnable {
    // the whole time
    Vector<Long> wholeTimeList;

    // the run time
    Vector<Long> runTimeList;

    private long initStartTime = 0;

    public IOTpyeTest(Vector<Long> wholeTimeList, Vector<Long> runTimeList) {
        initStartTime = System.currentTimeMillis();
        this.wholeTimeList = wholeTimeList;
        this.runTimeList = runTimeList;
    }

    public void readAndWrite() throws IOException {
        File sourceFile = new File("D:/sss.txt");

        BufferedReader input = new BufferedReader(new FileReader(sourceFile));
        // read source file,write into new file
        String line = null;
        while ((line=input.readLine())!=null){
            System.out.println(line);
        }
        input.close();
    }


    @Override
    public void run() {
        long start = System.currentTimeMillis();
        try {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            readAndWrite();
        }catch (IOException e)  {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();

        long wholeTime = end - initStartTime;
        long runTime = end - start;
        wholeTimeList.add(wholeTime);
        runTimeList.add(runTime);
        System.out.println("单个线程花费时间：" + (end - start));
    }
}
