package com.chiyi.jvm.memory;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author chiyi
 * @date 2019/8/5.
 */
public class Reorder {
    private byte a;
    private int b;
    private boolean c;
    private float d;
    private char e;

    public static void main(String[] args) {
        System.out.println(ClassLayout.parseClass(Reorder.class).toPrintable());
    }
}
