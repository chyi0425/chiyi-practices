package com.chiyi.designpattern.proxy;

/**
 * Created by 溢
 */
public class Proxy implements Subject {
    private Subject realSubject;
    public void request() {
        if(realSubject==null){
            realSubject = new RealSubject();
        }
        realSubject.request();
    }
}
