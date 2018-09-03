package com.chiyi.designpattern.visitor;

/**
 * @author chiyi
 * @date 2018/9/3.
 * Interface for the nodes in hierarchy
 */
public abstract class Unit {
    private Unit[] children;

    public Unit(Unit... children) {
        this.children = children;
    }

    public void accept(UnitVisitor visitor){
        for(Unit child:children){
            child.accept(visitor);
        }
    }
}
