package com.chiyi.designpattern.builder;

/**
 * Created by 溢
 */
public class BuilderClient {

    public static void main(String[] args) {
        Director director = new Director();
        Builder b1 = new ConcreteBuilder();
        Builder b2 = new ConcreteBuilder2();
        director.construct(b1);
        Product p1 = b1.getResult();
        p1.show();

        director.construct(b2);
        Product p2 = b2.getResult();
        p2.show();
    }
}
