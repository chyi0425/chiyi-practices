package com.chiyi.designpattern.decorator;

/**
 * Created by 溢
 */
public class Decorator implements Component {
    private Component component;

    public void setComponent(Component component) {
        this.component = component;
    }

    public void operation() {
        if(component!=null){
            component.operation();
        }
    }
}
