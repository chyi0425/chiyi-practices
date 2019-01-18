package com.chiyi.util;

import com.google.common.math.LongMath;
import org.junit.Test;

/**
 * @author chiyi
 * @date 2019/1/18.
 */
public class OrderIdGenerateTest {

    @Test
    public void generateConsumeOrderId() {
        System.out.println(OrderIdGenerate.generateConsumeOrderId(1,1,System.currentTimeMillis()));
        System.out.println(OrderIdGenerate.generateConsumeOrderId(1,1,System.currentTimeMillis()));
        System.out.println(OrderIdGenerate.generateConsumeOrderId(1,1,System.currentTimeMillis()));
        System.out.println(OrderIdGenerate.generateConsumeOrderId(1,1,System.currentTimeMillis()));
//        System.out.println(OrderIdGenerate.generateConsumeOrderId(1,1,System.currentTimeMillis()));
//        System.out.println(OrderIdGenerate.generateConsumeOrderId(1,1,System.currentTimeMillis()));
        System.out.println(LongMath.checkedPow(10,18));
    }
}