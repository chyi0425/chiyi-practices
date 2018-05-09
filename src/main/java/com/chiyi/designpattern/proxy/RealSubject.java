package com.chiyi.designpattern.proxy;

/**
 * Created by 溢
 */
public class RealSubject implements Subject {
    public void request() {
        System.out.println("真实的请求");
    }
}
