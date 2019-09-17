package com.chiyi.jvm.memory;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author chiyi
 * @date 2019/8/5.
 */
public class SubB extends SuperB {
    private int a;

    private long b;

    public static void main(String[] args) {
        System.out.println(ClassLayout.parseClass(SubB.class).toPrintable());
    }

}
