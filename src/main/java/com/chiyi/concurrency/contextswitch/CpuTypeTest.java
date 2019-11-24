package com.chiyi.concurrency.contextswitch;

import java.util.List;

public class CpuTypeTest implements Runnable {
    // the whole time
    List<Long> wholeTimeList;

    // the run time
    List<Long> runTimeList;

    private long initStartTime = 0;

    public CpuTypeTest(List<Long> wholeTimeList, List<Long> runTimeList) {
        initStartTime = System.currentTimeMillis();
        this.wholeTimeList = wholeTimeList;
        this.runTimeList = runTimeList;
    }

    /**
     * judge a number is prime or not
     *
     * @param number number for judge
     * @return
     */
    public boolean isPrime(final int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * count the prime number between lower and upper
     *
     * @param lower lower
     * @param upper upper
     * @return
     */
    public int countPrimes(final int lower, final int upper) {
        int total = 0;
        for (int i = lower; i <= upper; i++) {
            if (isPrime(i)) {
                total++;
            }
        }
        return total;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countPrimes(1, 1000000);
        long end = System.currentTimeMillis();

        long wholeTime = end - initStartTime;
        long runtime = end - start;
        wholeTimeList.add(wholeTime);
        runTimeList.add(runtime);
        System.out.println("单个线程花费时间：" + (end - start));
    }
}
