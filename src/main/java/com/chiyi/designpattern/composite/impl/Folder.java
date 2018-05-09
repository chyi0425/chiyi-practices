package com.chiyi.designpattern.composite.impl;

import java.util.ArrayList;
import java.util.List;

/**
 * container component
 * Created by chiyi on 2017/8/11.
 */
public class Folder implements AbstractFile {
    // define collection, save files
    private List<AbstractFile> fileList = new ArrayList<>();

    private String name;

    public Folder(String name) {
        this.name = name;
    }

    @Override
    public void add(AbstractFile file) {
        fileList.add(file);
    }

    @Override
    public void remove(AbstractFile file) {
        fileList.remove(file);
    }

    @Override
    public AbstractFile getChild(int i) {
        return fileList.get(i);
    }

    @Override
    public void killVirus() {
        // simulate kill virus
        System.out.println("*** kill virus on folder:"+name);

        for (AbstractFile file:fileList){
            file.killVirus();
        }
    }
}
