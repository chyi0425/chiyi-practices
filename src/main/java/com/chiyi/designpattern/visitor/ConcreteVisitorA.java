package com.chiyi.designpattern.visitor;

/**
 * @author chiyi
 */
public class ConcreteVisitorA implements Visitor {

    @Override
    public void visit(ConcreteElementA able) {
        able.operate();
    }

    @Override
    public void visit(ConcreteElementB able) {
        able.operate();
    }
}
