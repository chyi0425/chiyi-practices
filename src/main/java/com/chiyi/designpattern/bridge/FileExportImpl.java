package com.chiyi.designpattern.bridge;

/**
 * the interface that read content from file and connect database
 * @author chiyi
 */
public interface FileExportImpl {

    /**
     * fetch data from database
     * @param jdbcDriver
     * @return
     */
    String readContent();
}
