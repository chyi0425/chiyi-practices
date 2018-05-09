package com.chiyi.designpattern.composite.impl;

/**
 * leaf component
 * Created by chiyi on 2017/8/11.
 */
public class TextFile implements AbstractFile {
    private String name;

    public TextFile(String name) {
        this.name = name;
    }

    @Override
    public void add(AbstractFile file) {
        System.out.println("sorry,do not support this method");
    }

    @Override
    public void remove(AbstractFile file) {
        System.out.println("sorry,do not support this method");

    }

    @Override
    public AbstractFile getChild(int i) {
        System.out.println("sorry,do not support this method");
        return null;
    }

    @Override
    public void killVirus() {
        // simulate kill virus
        System.out.println("---- kill virus on text file :" + name);
    }
}
