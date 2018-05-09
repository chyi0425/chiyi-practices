package com.chiyi.designpattern.bridge;

/**
 * @author chiyi
 */
public class PdfFileExpot extends FileExportAbstraction {

    @Override
    public void exportFile() {
        String readContent = fileSource.readContent();
        System.out.println(readContent + ", save ti to pdf file");
    }
}
