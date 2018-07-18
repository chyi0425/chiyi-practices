package com.chiyi.io;

import java.io.*;
import java.net.URL;

/**
 * @author chiyi
 * @date 2018/7/18.
 */
public class IOTest {
    /**
     * 递归地输出一个目录下所有文件.
     * @param dir
     */
    public static void listAllFiles(File dir) {
        if (dir == null || !dir.exists()) {
            return;
        }
        if (dir.isFile()) {
            System.out.println(dir.getName());
        }
        for (File file : dir.listFiles()) {
            listAllFiles(file);
        }
    }

    /**
     * 使用字节流操作进行文件复制.
     * @param src
     * @param dist
     * @throws IOException
     */
    public static void copyFile(String src,String dist) throws IOException {
        FileInputStream in = new FileInputStream(src);
        FileOutputStream out = new FileOutputStream(dist);
        byte[] buffer = new byte[20*1024];
        // read() 最多读取buffer.length个字节
        // 返回的是实际读取的个数
        // 返回-1的时候表示对到eof，即文化尾
        while (in.read(buffer,0,buffer.length)!=-1){
            out.write(buffer);
        }
        in.close();
        out.close();
    }

    /**
     * 逐行输出文本文件的内容.
     * @param filePath
     */
    public static void readFileContent(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line=bufferedReader.readLine())!=null){
            System.out.println(line);
        }
        // 装饰器模式使得BUfferedReader组合了一个Reader对象
        // 在调用bufferedReader的close()方法的时候回去调用fileReader的close()方法
        // 因此只要一个close()调用即可
        bufferedReader.close();
    }

    /**
     * 直接从URL读取字节流数据。
     * @throws IOException
     */
    public static void readFromURL() throws IOException {
        URL url = new URL("http://www.baidu.com");
        // 字节流
        InputStream is = url.openStream();
        // 字符流
        InputStreamReader isr = new InputStreamReader(is,"utf-8");
        BufferedReader br = new BufferedReader(isr);
        String line = br.readLine();
        while (line!=null){
            System.out.println(line);
            line = br.readLine();
        }
        br.close();
    }

    public static void main(String[] args) throws IOException {
        readFromURL();
    }
}
