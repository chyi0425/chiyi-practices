package com.chiyi.designpattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chiyi on 2017/8/11.
 */
public class Composite implements Component {
    private List<Component> list = new ArrayList<>();

    @Override
    public void add(Component component) {
        list.add(component);
    }

    @Override
    public void remove(Component component) {
        list.remove(component);
    }

    @Override
    public Component getChild(int i) {
        return list.get(i);
    }

    @Override
    public void operation() {
        // container's operation
        // reduce children's operation
        for (Component component :list){
            component.operation();
        }
    }
}
