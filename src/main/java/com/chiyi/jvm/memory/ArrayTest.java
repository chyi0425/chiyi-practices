package com.chiyi.jvm.memory;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author chiyi
 * @date 2019/8/5.
 */
public class ArrayTest {

    public static void main(String[] args) {
        System.out.println(ClassLayout.parseInstance(new int[3]).toPrintable());
    }
}
