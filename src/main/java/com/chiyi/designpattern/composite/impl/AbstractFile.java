package com.chiyi.designpattern.composite.impl;

/**
 * Created by chiyi on 2017/8/11.
 */
public interface AbstractFile {
    void add(AbstractFile file);

    void remove(AbstractFile file);

    AbstractFile getChild(int i);

    void killVirus();
}
