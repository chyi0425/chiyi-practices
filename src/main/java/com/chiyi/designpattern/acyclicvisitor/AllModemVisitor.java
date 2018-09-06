package com.chiyi.designpattern.acyclicvisitor;

/**
 * @author chiyi
 * @date 2018/9/4.
 * All modemVisitor interface extends all visitor interface.
 */
public interface AllModemVisitor extends ModemVisitor, ZoomVisitor, HayesVisitor {
}
