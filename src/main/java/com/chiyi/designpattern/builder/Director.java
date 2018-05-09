package com.chiyi.designpattern.builder;

/**
 * Created by 溢
 */
public class Director {
    public void construct(Builder builder){
        builder.buildPartA();
        builder.buildPartB();
    }
}
