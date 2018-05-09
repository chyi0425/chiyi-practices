package com.chiyi.jvm.classloader;

/**
 * Created by 溢
 */
public class LoaderTest {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader = LoaderTest.class.getClassLoader();
        System.out.println(loader);
        // 使用ClassLoader.loadClass()来加载类，不会执行初始化块
        System.out.println("use ClassLoader.loadClass started");
        loader.loadClass("com.chiyi.jvm.classloader.TestClass");
        System.out.println("use ClassLoader.loadClass end.");
        // 使用Class.forName()来加载类，默认会执行初始化块
        System.out.println("use Class.forName started");
        Class.forName("com.chiyi.jvm.classloader.TestClass");
        System.out.println("use Class.forName end");
        // 使用Class.forName()来加载类，并指定ClassLoader，初始化时不执行静态块
        System.out.println("use Class.forName with ClassLoader started");
        Class.forName("com.chiyi.jvm.classloader.TestClass",true,loader);
        System.out.println("use Class.forName with ClassLoader end");
    }
}
