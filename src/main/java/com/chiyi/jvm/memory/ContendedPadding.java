package com.chiyi.jvm.memory;

import org.openjdk.jol.info.ClassLayout;
import sun.misc.Contended;

/**
 * @author chiyi
 * @date 2019/8/5.
 */
public class ContendedPadding {
    @Contended
    public volatile long valueA;
    public volatile long valueB;

    public static void main(String[] args) {
        System.out.println(ClassLayout.parseInstance(new ContendedPadding()).toPrintable());
    }
}
