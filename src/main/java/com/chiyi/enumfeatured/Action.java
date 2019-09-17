package com.chiyi.enumfeatured;

/**
 * @author chiyi
 * @date 2019/9/17.
 */
public enum Action {
    ONE {
        @Override
        public void action() {
        }
    },
    TWO {
        @Override
        public void action() {
        }
    },
    THREE {
        @Override
        public void action() {
        }
    };

    public abstract void action();
}
