package com.chiyi.designpattern.builder;

/**
 * Created by 溢
 */
public interface Builder {
    void buildPartA();
    void buildPartB();
    Product getResult();
}
