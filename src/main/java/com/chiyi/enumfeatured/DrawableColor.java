package com.chiyi.enumfeatured;

/**
 * @author chiyi
 * @date 2019/9/17.
 */
public enum DrawableColor {
    red {
        @Override
        public void draw() {

        }
    }, green {
        @Override
        public void draw() {

        }
    }, blue {
        @Override
        public void draw() {

        }
    };

    public abstract void draw();
}
