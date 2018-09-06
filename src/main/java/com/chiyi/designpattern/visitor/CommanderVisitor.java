package com.chiyi.designpattern.visitor;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommanderVisitor implements UnitVisitor {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommanderVisitor.class);

    @Override
    public void visitSoldier(Soldier soldier) {
        // Do nothing.
    }

    @Override
    public void visitSergeant(Sergeant sergeant) {
        // Do nothing.
    }

    @Override
    public void visitCommander(Commander commander) {
        LOGGER.info("Good to see you {}", commander);
        System.out.println("Good to see you " + commander);
    }
}
