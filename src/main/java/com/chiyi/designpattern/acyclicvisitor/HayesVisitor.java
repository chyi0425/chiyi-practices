package com.chiyi.designpattern.acyclicvisitor;

/**
 * @author chiyi
 * @date 2018/9/4.
 * HayesVisitor interface.
 */
public interface HayesVisitor extends ModemVisitor{
    void visit(Hayes hayes);
}
