package com.chiyi;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

import java.util.HashSet;

import static java.lang.System.out;

/**
 * @author Aleksey Shipilev
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
        out.println(VM.current().details());
        out.println(ClassLayout.parseClass(A.class).toPrintable());
        HashSet<String> instance = new HashSet<>(10000000);
        out.println(ClassLayout.parseInstance(instance).toPrintable());

        out.println(ClassLayout.parseInstance(instance).toPrintable());

    }

    public static class A {
        boolean f;
    }

}