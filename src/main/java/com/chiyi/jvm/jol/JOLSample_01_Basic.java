package com.chiyi.jvm.jol;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

/**
 * @author chiyi
 * @date 2019/8/6.
 */
public class JOLSample_01_Basic {
    /*
     * This sample showcases the basic field layout.
     * You can see a few notable things here:
     *   a) how much the object header consumes;
     *   b) how fields are laid out;
     *   c) how the external alignment beefs up the object size
     */

    public static void main(String[] args) throws Exception {
        System.out.println(VM.current().details());
        System.out.println(ClassLayout.parseClass(A.class).toPrintable());
    }

    public static class A {
        boolean f;
    }
}
