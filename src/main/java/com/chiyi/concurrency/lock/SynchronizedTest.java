package com.chiyi.concurrency.lock;

/**
 * @author chiyi
 */
public class SynchronizedTest {
    public synchronized void test1() {

    }

    public void test2() {
        synchronized (this) {

        }
    }
    /**
     public void test2();
     Code:
     0: aload_0
     1: dup
     2: astore_1
     3: monitorenter
     4: aload_1
     5: monitorexit
     6: goto          14
     9: astore_2
     10: aload_1
     11: monitorexit
     12: aload_2
     13: athrow
     14: return
     Exception table:
     from    to  target type
     4     6     9   any
     9    12     9   any
     */
}
