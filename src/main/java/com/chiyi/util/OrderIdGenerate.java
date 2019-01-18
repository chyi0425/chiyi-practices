package com.chiyi.util;

import com.google.common.math.LongMath;

/**
 * @author chiyi
 * @date 2019/1/18.
 */
public class OrderIdGenerate {
    public static Long generateConsumeOrderId(int advId, int accountType, long timestamp) {
        long a = LongMath.checkedPow(10, 18);
        long b = LongMath.checkedPow(10, 17);
        long c = accountType * LongMath.checkedPow(10, 16);
        long d = advId * LongMath.checkedPow(10, 8);
        long e = timestamp ;
        return a + b + c + d + e;
    }

}
