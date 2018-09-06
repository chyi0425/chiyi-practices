package com.chiyi.designpattern.visitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SoldierVisitor implements UnitVisitor {
    private static final Logger LOGGER = LoggerFactory.getLogger(SoldierVisitor.class);

    @Override
    public void visitSoldier(Soldier soldier) {
        LOGGER.info("Greetings {}", soldier);
        System.out.println("Greetings " + soldier);
    }

    @Override
    public void visitSergeant(Sergeant sergeant) {
        // Do nothing.
    }

    @Override
    public void visitCommander(Commander commander) {
        // Do nothing.
    }
}
