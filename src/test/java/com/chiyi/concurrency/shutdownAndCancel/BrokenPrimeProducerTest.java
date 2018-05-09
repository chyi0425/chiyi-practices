package com.chiyi.concurrency.shutdownAndCancel;

import org.junit.Test;

import java.math.BigInteger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * @author chiyi
 */
public class BrokenPrimeProducerTest {
    @Test
    public void run() throws Exception {
        BlockingQueue<BigInteger> primes = new ArrayBlockingQueue<BigInteger>(10);
        BrokenPrimeProducer producer = new BrokenPrimeProducer(primes);
        producer.start();
        try{
            while (needMorePrimes()){
                consume(primes.take());
            }
        }finally {
            producer.cancel();
        }

    }

    private void consume(BigInteger take) {
    }

    private boolean needMorePrimes() throws InterruptedException {
        int i =0;
        for(;i<10;i++){
            Thread.sleep(1000);
            
        }
        return (i==9);
    }


}