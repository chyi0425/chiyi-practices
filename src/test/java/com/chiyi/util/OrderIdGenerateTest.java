package com.chiyi.util;

import com.google.common.math.LongMath;
import org.junit.Test;

import java.util.Random;

/**
 * @author chiyi
 * @date 2019/1/18.
 */
public class OrderIdGenerateTest {

    @Test
    public void generateConsumeOrderId() throws InterruptedException {
        int x = 1;
        int n1 = 5;
        int n2 = 6;
        int n3 = 7;
        int m1 = 0;
        int m2 = 0;
        int m3 = 0;
        Random random = new Random(3);
        while (true) {
            Thread.sleep(1000);
            int r = random.nextInt(3);
            if (r == 0 && flag(m1, n1, x)) {
                System.out.println("m1++");
                m1++;
                System.out.println(m1);
                continue;
            }
            if (r == 1 && flag(m2, n2, x)) {
                System.out.println("m2++");
                m2++;
                System.out.println(m2);
                continue;
            }
            if (r == 2 && flag(m3, n3, x)) {
                System.out.println("m3++");
                m3++;
                System.out.println(m3);
                continue;
            }
            if ((!flag(m3, n3, x)) && (!flag(m1, n1, x)) && (!flag(m2, n2, x))) {
                System.out.println("------------------------------------");
                x++;
                System.out.println("x++");
                System.out.println(x);
            }
        }
    }

    public boolean flag(int m, int n, int x) {
        if (m % (x * n + 1) == n * x) {
            return false;
        } else {
            return true;
        }
    }
}