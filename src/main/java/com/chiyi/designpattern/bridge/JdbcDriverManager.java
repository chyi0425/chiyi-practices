package com.chiyi.designpattern.bridge;

/**
 * @author chiyi
 */
public class JdbcDriverManager {

    public String connectAndReadOracle(){
        // simulate the code connect to oracle
        System.out.println("connect to database oracle success...");
        // simulate the code fetch data from oracle
        String content = "fetch data form database oracle success...";
        return content;
    }

    public String connectAndReadMysql(){
        // simulate the code connect to oracle
        System.out.println("connect to database mysql success...");
        // simulate the code fetch data from oracle
        String content = "fetch data form database mysql success...";
        return content;
    }

    public String connectAndReadSqlServer(){
        // simulate the code connect to oracle
        System.out.println("connect to database SqlServer success...");
        // simulate the code fetch data from oracle
        String content = "fetch data form database SqlServer success...";
        return content;
    }

}
