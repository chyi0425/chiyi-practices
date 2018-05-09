package com.chiyi.designpattern.decorator;

/**
 * Created by 溢
 */
public class ConcreteDecoratorB extends Decorator {
    @Override
    public void operation() {
        super.operation();
        addedBehavior();
        System.out.println("an decoratorB's operation");
    }

    private void addedBehavior(){
        System.out.println("some function decoratorB have");
    }
}
