package com.chiyi.jvm.memory;

import org.openjdk.jol.vm.VM;

/**
 * @author chiyi
 * 1、虚拟机栈：每个线程有一个私有的栈，随着线程的创建而创建。
 * 栈里面存着的是一种叫“栈帧”的东西，每个方法会创建一个栈帧，
 * 栈帧中存放了局部变量表（基本数据类型和对象引用）、操作数栈、方法出口等信息。
 * 栈的大小可以固定也可以动态扩展。
 * 当栈调用深度大于JVM所允许的范围，会抛出StackOverflowError的错误，
 * 不过这个深度范围不是一个恒定的值，我们通过下面这段程序可以测试一下这个结果：
 */
public class StackErrorMock {
    private static  int index = 1;

    public void call(){
        index ++;
        call();
    }

    public static void main(String[] args) {
        StackErrorMock stackErrorMock = new StackErrorMock();
        try{
//            stackErrorMock.call();
            System.out.println(VM.current().details());
        }catch (Throwable e){
            System.out.println("Stack deep : "+index);
            e.printStackTrace();
        }
    }
}
