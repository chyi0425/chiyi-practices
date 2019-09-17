package com.chiyi.jvm.memory;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author chiyi
 * @date 2019/8/5.
 */
public class Order {
    private int ignoreMeTentatively;
    private byte a;
    private boolean b;
    private char c;
    private short d;
    private int e;
    private float f;
    private double g;
    private long h;
    private Object i;

    public static void main(String[] args) {
        System.out.println(ClassLayout.parseClass(Order.class).toPrintable());
    }
}
