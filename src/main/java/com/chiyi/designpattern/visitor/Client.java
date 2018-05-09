package com.chiyi.designpattern.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chiyi
 */
public class Client {

    public static void main(String[] args) {
        Visitor v1 = new ConcreteVisitorA();
        List<Visitable> list = new ArrayList<>();
        list.add(new ConcreteElementA());
        list.add(new ConcreteElementB());

        for(Visitable visitable:list){
            visitable.accept(v1);
        }
    }
}
