package com.chiyi.designpattern.acyclicvisitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author chiyi
 * @date 2018/9/4.
 * ConfigureForUnixVisitor class implements zoom's visit method for Unix
 * manufacturer
 */
public class ConfigureForUnixVisitor implements ModemVisitor,ZoomVisitor {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigureForUnixVisitor.class);

    @Override
    public void visit(Zoom zoom) {
        LOGGER.info(zoom + " used with Unix configurator.");
        System.out.println(zoom + " used with Unix configurator.");
    }
}
