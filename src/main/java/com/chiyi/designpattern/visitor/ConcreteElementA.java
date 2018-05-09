package com.chiyi.designpattern.visitor;

/**
 * @author chiyi
 */
public class ConcreteElementA implements Visitable {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void operate(){
        System.out.println("ConcreteElementA ...");
    }
}
