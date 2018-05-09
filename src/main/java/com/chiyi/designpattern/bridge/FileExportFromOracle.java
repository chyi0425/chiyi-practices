package com.chiyi.designpattern.bridge;

/**
 * @author chiyi
 */
public class FileExportFromOracle implements FileExportImpl {

    @Override
    public String readContent() {
        JdbcDriverManager jdbcDriverManager = new JdbcDriverManager();
        return jdbcDriverManager.connectAndReadOracle();
    }
}
