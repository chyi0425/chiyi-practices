package com.chiyi.designpattern.acyclicvisitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author chiyi
 * @date 2018/9/4.
 */
public class ConfigureForDosVisitor implements AllModemVisitor {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigureForDosVisitor.class);

    @Override
    public void visit(Hayes hayes) {
        LOGGER.info(hayes + " used with Dos configurator.");
        System.out.println(hayes + " used with Dos configurator.");
    }

    @Override
    public void visit(Zoom zoom) {
        LOGGER.info(zoom + " used with Dos configurator.");
        System.out.println(zoom + " used with Dos configurator.");
    }
}
