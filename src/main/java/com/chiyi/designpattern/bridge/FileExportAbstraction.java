package com.chiyi.designpattern.bridge;

/**
 * abstract class
 * the class to export file format
 * @author chiyi
 */
public abstract class FileExportAbstraction {
    protected FileExportImpl fileSource;

    public void setFileSource(FileExportImpl fileSource) {
        this.fileSource = fileSource;
    }

    public abstract void exportFile();
}
