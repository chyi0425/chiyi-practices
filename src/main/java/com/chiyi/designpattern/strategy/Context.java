package com.chiyi.designpattern.strategy;

/**
 * Created by 溢
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }
    public void contextInterface(){
        strategy.operate();
    }
}
