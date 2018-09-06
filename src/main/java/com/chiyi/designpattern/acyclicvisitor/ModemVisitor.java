package com.chiyi.designpattern.acyclicvisitor;

/**
 * @author chiyi
 * @date 2018/9/4.
 * ModemVisitor interface does not contain any visit methods so that it does not
 * depend on the visited hierarchy.Each derivative's visit method is declared in
 * its own visitor interface.
 */
public interface ModemVisitor {
}
