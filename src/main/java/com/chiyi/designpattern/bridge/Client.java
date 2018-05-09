package com.chiyi.designpattern.bridge;

/**
 * @author chiyi
 */
public class Client {

    public static void main(String[] args) {
        FileExportImpl fileOracle = new FileExportFromOracle();
        FileExportImpl fileMysql = new FileExportFromMysql();
        FileExportImpl fileSqlServer = new FileExportFromSqlServer();

        FileExportAbstraction fileTxtExport = new TextFileExpot();
        FileExportAbstraction fileXmlExport = new XmlFileExpot();
        FileExportAbstraction filePdfExport = new PdfFileExpot();

        fileXmlExport.setFileSource(fileOracle);
        fileXmlExport.exportFile();

        System.out.println("--------------------------------------\n");
        fileTxtExport.setFileSource(fileMysql);
        fileTxtExport.exportFile();
        System.out.println("--------------------------------------\n");

        filePdfExport.setFileSource(fileSqlServer);
        filePdfExport.exportFile();
    }
}
