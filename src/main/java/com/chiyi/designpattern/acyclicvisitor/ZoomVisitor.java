package com.chiyi.designpattern.acyclicvisitor;

/**
 * @author chiyi
 * @date 2018/9/4.
 * ZoomVisitor interface.
 */
public interface ZoomVisitor extends ModemVisitor{
    void visit(Zoom zoom);
}
