package com.chiyi.designpattern.bridge;

/**
 * @author chiyi
 */
public class FileExportFromSqlServer implements FileExportImpl{

    @Override
    public String readContent() {
        JdbcDriverManager jdbcDriverManager = new JdbcDriverManager();
        return jdbcDriverManager.connectAndReadSqlServer();
    }
}
