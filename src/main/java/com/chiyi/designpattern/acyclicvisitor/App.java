package com.chiyi.designpattern.acyclicvisitor;

/**
 * @author chiyi
 * @date 2018/9/4.
 */
public class App {

    public static void main(String[] args) {
        ConfigureForUnixVisitor conUnix = new ConfigureForUnixVisitor();
        ConfigureForDosVisitor conDos = new ConfigureForDosVisitor();

        Zoom zoom = new Zoom();
        Hayes hayes = new Hayes();

        hayes.accept(conDos); // hayes modem with Dos configurator
        zoom.accept(conDos); // Zoom modem with Dos configurator
        hayes.accept(conUnix); // hayes modem with Unix configurator
        zoom.accept(conUnix); // Zoom modem with Unix configurator
    }
}
