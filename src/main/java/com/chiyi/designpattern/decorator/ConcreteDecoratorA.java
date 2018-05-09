package com.chiyi.designpattern.decorator;

/**
 * Created by 溢
 */
public class ConcreteDecoratorA extends Decorator {
    private String addedState;

    @Override
    public void operation() {
        super.operation();
        addedState = "new state";
        System.out.println("an decoratorA's operation");
    }
}
