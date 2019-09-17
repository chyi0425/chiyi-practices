package com.chiyi.jvm.memory;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author chiyi
 * @date 2019/8/5.
 */
public class Padding {
    private char a;
    private boolean b;
    private long c;
    private Object d;

    public static void main(String[] args) {
        System.out.println(ClassLayout.parseClass(Padding.class).toPrintable());
    }
}
