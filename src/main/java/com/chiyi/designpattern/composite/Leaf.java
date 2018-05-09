package com.chiyi.designpattern.composite;

/**
 * Created by chiyi on 2017/8/11.
 */
public class Leaf implements Component {
    @Override
    public void add(Component component) {
        // handle exception or error message
    }

    @Override
    public void remove(Component component) {
        // handle exception or error message
    }

    @Override
    public Component getChild(int i) {
        // handle exception or error message
        return null;
    }

    @Override
    public void operation() {
        // leaf's operation
    }
}
