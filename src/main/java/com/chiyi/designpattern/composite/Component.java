package com.chiyi.designpattern.composite;

/**
 * Created by chiyi on 2017/8/11.
 */
public interface Component {
    void add(Component component);

    void remove(Component component);

    Component getChild(int i);

    void operation();
}
