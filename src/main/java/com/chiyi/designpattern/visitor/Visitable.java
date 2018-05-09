package com.chiyi.designpattern.visitor;

/**
 * @author chiyi
 */
public interface Visitable {
    void accept(Visitor visitor);
}
