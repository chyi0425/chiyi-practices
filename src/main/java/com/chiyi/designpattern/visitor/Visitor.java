package com.chiyi.designpattern.visitor;

/**
 * @author chiyi
 */
public interface Visitor {
    public void visit(ConcreteElementA able);
    public void visit(ConcreteElementB able);

}
