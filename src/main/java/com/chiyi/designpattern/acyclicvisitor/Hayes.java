package com.chiyi.designpattern.acyclicvisitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author chiyi
 * @date 2018/9/4.
 */
public class Hayes extends Modem {
    private static final Logger LOGGER = LoggerFactory.getLogger(Hayes.class);

    /**
     * Accepts all visitors but honors only HayesVisitor
     *
     * @param modemVisitor
     */
    @Override
    public void accept(ModemVisitor modemVisitor) {
        try {
            ((HayesVisitor) modemVisitor).visit(this);
        } catch (ClassCastException e) {
            LOGGER.error("Unable to cast to HayesVisitor");
        }
    }

    /**
     * Hayes modem's toString
     * method
     */
    @Override
    public String toString() {
        return "Hayes modem";
    }
}
