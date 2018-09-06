package com.chiyi.designpattern.acyclicvisitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author chiyi
 * @date 2018/9/4.
 */
public class Zoom extends Modem {
    private static final Logger LOGGER = LoggerFactory.getLogger(Zoom.class);

    /**
     * Accepts all visitors but honors only ZoomVisitor
     *
     * @param modemVisitor
     */
    @Override
    public void accept(ModemVisitor modemVisitor) {
        try {
            ((ZoomVisitor) modemVisitor).visit(this);
        } catch (ClassCastException e) {
            LOGGER.error("Unable to cast to ZoomVisitor");
        }
    }

    /**
     * Zoom modem's toString
     * method
     */
    @Override
    public String toString() {
        return "Zoom modem";
    }
}
