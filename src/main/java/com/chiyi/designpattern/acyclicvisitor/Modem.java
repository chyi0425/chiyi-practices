package com.chiyi.designpattern.acyclicvisitor;

/**
 * @author chiyi
 * @date 2018/9/4.
 */
public abstract class Modem {
    public abstract void accept(ModemVisitor modemVisitor);
}
