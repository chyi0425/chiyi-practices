package com.chiyi.jvm.memory;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author chiyi
 * @date 2019/8/5.
 */
public class SubA extends SupperA {
    private long d;

    public static void main(String[] args) {
        System.out.println(ClassLayout.parseClass(SubA.class).toPrintable());
    }
}
